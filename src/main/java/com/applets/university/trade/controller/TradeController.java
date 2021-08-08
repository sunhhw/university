package com.applets.university.trade.controller;

import com.applets.university.common.api.AjaxResult;
import com.applets.university.common.util.AuthUtil;
import com.applets.university.common.util.FileUploadUtil;
import com.applets.university.trade.converter.TradeConverter;
import com.applets.university.trade.entity.Trade;
import com.applets.university.trade.entity.TradeImage;
import com.applets.university.trade.service.ITradeImageService;
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
@Api(value = "二手交易模块")
public class TradeController {

    @Autowired
    private ITradeService transactionService;

    @Autowired
    private ITradeImageService tradeImageService;

    @PostMapping("")
    @ApiOperation("发布")
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult release(@RequestParam("file") List<MultipartFile> file,
                              @RequestParam("typeId") Integer typeId,
                              @RequestParam("title") String title,
                              @RequestParam("detail") String detail,
                              @RequestParam("price") Double price,
                              @RequestParam("originalPrice") Double originalPrice) throws IOException {
        // 1. 获取用户openId
        String openId = AuthUtil.getOpenId();
        // 2. 上传发布信息
        Integer status = 1;
        Trade trade = TradeConverter.INSTANCE.toTransaction(typeId, title, detail, openId, price, originalPrice, status);
        boolean isSuccess = transactionService.save(trade);
        if (!isSuccess) {
            return AjaxResult.failed("发布失败，请稍后再试！");
        }
        // 3. 上传图片信息
        for (MultipartFile multipartFile : file) {
            // 文件上传
            String path = FileUploadUtil.upload(multipartFile);
            Integer tradeId = trade.getId();
            TradeImage tradeImage = TradeConverter.INSTANCE.toTradeImage(tradeId, path);
            tradeImageService.save(tradeImage);
        }
        return AjaxResult.success();
    }


}
