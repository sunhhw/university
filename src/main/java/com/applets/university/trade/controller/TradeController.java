package com.applets.university.trade.controller;

import com.applets.university.common.api.AjaxResult;
import com.applets.university.common.constant.ModuleConstant;
import com.applets.university.common.util.AuthUtil;
import com.applets.university.common.util.FileUploadUtil;
import com.applets.university.trade.converter.TradeConverter;
import com.applets.university.trade.entity.Image;
import com.applets.university.trade.entity.Trade;
import com.applets.university.trade.service.IImageService;
import com.applets.university.trade.service.ITradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @auther shw
 * @date 2021/8/7
 * 二手交易模块
 */
@RequestMapping("/transaction")
@RestController
@Api(tags = "二手交易模块")
public class TradeController {

    @Autowired
    private ITradeService tradeService;

    @Autowired
    private IImageService tradeImageService;

    @PostMapping("")
    @ApiOperation("发布")
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult release(@RequestParam("file") List<MultipartFile> file,
                              @RequestParam("typeId") Integer typeId,
                              @RequestParam("detail") String detail,
                              @RequestParam("price") Double price,
                              @RequestParam("originalPrice") Double originalPrice,
                              @RequestParam("finenessId") Integer finenessId) throws IOException {
        // 1. 获取用户openId
        String openId = AuthUtil.getOpenId();
        // 2. 上传发布信息
        Integer status = 1;
        Trade trade = TradeConverter.INSTANCE.toTrade(typeId, detail, openId, price, originalPrice, status, finenessId);
        boolean isSuccess = tradeService.save(trade);
        if (!isSuccess) {
            return AjaxResult.failed("发布失败，请稍后再试！");
        }

        // 限制不可超过5张照片
        if (file.size() > 5) {
            return AjaxResult.failed("图片不可超过5张");
        }

        // 3. 上传图片信息
        for (int i = 0; i < file.size(); i++) {
            // 文件上传
            // 默认第一张为封面
            int cover = i == 0 ? 1 : 0;
            String path = FileUploadUtil.upload(file.get(i));
            Integer tradeId = trade.getId();
            Image image = TradeConverter.INSTANCE.toImage(tradeId, path, cover, ModuleConstant.TRADE);
            tradeImageService.save(image);
        }

        return AjaxResult.success();
    }


}
