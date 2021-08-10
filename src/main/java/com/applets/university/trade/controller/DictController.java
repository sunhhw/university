package com.applets.university.trade.controller;


import com.applets.university.common.api.AjaxResult;
import com.applets.university.common.constant.DictConstant;
import com.applets.university.common.entity.BaseEntity;
import com.applets.university.trade.converter.TradeConverter;
import com.applets.university.trade.entity.Dict;
import com.applets.university.trade.service.IDictService;
import com.applets.university.trade.vo.DictVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author shw
 * @since 2021-08-09
 */
@RestController
@RequestMapping("/dict")
@Api(tags = "字典数据")
public class DictController {

    @Autowired
    private IDictService dictService;

    @GetMapping("/fineness")
    @ApiOperation("遍历成色")
    public AjaxResult listFineness() {
        LambdaQueryWrapper<Dict> wrapper = new LambdaQueryWrapper<Dict>()
                .eq(Dict::getType, DictConstant.FINENESS)
                .eq(BaseEntity::getDeleted, 0)
                .groupBy(Dict::getSort);
        List<Dict> list = dictService.list(wrapper);
        List<DictVO> dictVOList = TradeConverter.INSTANCE.toDictVoList(list);
        return AjaxResult.success(dictVOList);
    }

    @GetMapping("/category")
    @ApiOperation("遍历商品类型")
    public AjaxResult listType() {
        LambdaQueryWrapper<Dict> wrapper = new LambdaQueryWrapper<Dict>()
                .eq(Dict::getType, DictConstant.CATEGORY)
                .eq(BaseEntity::getDeleted, 0)
                .groupBy(Dict::getSort);
        List<Dict> list = dictService.list(wrapper);
        List<DictVO> dictVOList = TradeConverter.INSTANCE.toDictVoList(list);
        return AjaxResult.success(dictVOList);
    }


}
