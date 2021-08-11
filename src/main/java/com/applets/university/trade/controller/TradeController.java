package com.applets.university.trade.controller;

import com.applets.university.common.api.AjaxResult;
import com.applets.university.common.constant.ModuleConstant;
import com.applets.university.common.util.AuthUtil;
import com.applets.university.common.util.FileUploadUtil;
import com.applets.university.trade.converter.TradeConverter;
import com.applets.university.trade.dto.TradeParamDto;
import com.applets.university.trade.entity.Image;
import com.applets.university.trade.entity.Trade;
import com.applets.university.trade.service.IImageService;
import com.applets.university.trade.service.ITradeService;
import com.applets.university.trade.vo.TradeInfoVO;
import com.applets.university.trade.vo.TradeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

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

    @PostMapping
    @ApiOperation("发布")
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult release(@RequestParam("files") List<MultipartFile> files,
                              @RequestParam("categoryId") Integer categoryId,
                              @RequestParam("detail") String detail,
                              @RequestParam("price") Double price,
                              @RequestParam("originalPrice") Double originalPrice,
                              @RequestParam("finenessId") Integer finenessId,
                              @RequestParam("schoolId") Integer schoolId) {
        // 1. 获取用户openId
        String openId = AuthUtil.getOpenId();
        // 2. 上传发布信息
        Integer status = 1;
        Trade trade = TradeConverter.INSTANCE.toTrade(categoryId, detail, openId, price, originalPrice, status, finenessId, schoolId);
        boolean isSuccess = tradeService.save(trade);
        if (!isSuccess) {
            return AjaxResult.failed("发布失败，请稍后再试！");
        }

        // 限制不可超过5张照片
        if (files.size() > 5) {
            return AjaxResult.failed("图片不可超过5张");
        }

        // 3. 上传图片信息
        for (int i = 0; i < files.size(); i++) {
            // 文件上传
            // 默认第一张为封面
            int cover = i == 0 ? 1 : 0;
            String path = FileUploadUtil.upload(files.get(i));
            Integer tradeId = trade.getId();
            Image image = TradeConverter.INSTANCE.toImage(tradeId, path, cover, ModuleConstant.TRADE);
            tradeImageService.save(image);
        }

        return AjaxResult.success();
    }

    @GetMapping
    @ApiOperation("遍历所有商品")
    public AjaxResult listTrade(@RequestBody TradeParamDto param) {
        List<TradeVO> tradeVOList = tradeService.listTrade(param);
        return AjaxResult.success(tradeVOList);
    }

    @GetMapping("/{id}")
    @ApiOperation("商品详情")
    public AjaxResult getTradeInfo(@PathVariable("id") Integer id) {
        // 给该商品的浏览量+1
        Trade trade = tradeService.getById(id);
        if (Objects.isNull(trade)) {
            return AjaxResult.failed("该商品不存在！");
        }
        trade.setViews(trade.getViews() + 1);
        tradeService.updateById(trade);
        // 获取商品详情
        List<TradeInfoVO> tradeVOList = tradeService.getTradeInfo(id);
        return AjaxResult.success(tradeVOList);
    }

}
