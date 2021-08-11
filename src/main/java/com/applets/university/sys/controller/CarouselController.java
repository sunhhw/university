package com.applets.university.sys.controller;


import com.applets.university.common.api.AjaxResult;
import com.applets.university.sys.converter.SysConverter;
import com.applets.university.sys.entity.Carousel;
import com.applets.university.sys.service.ICarouselService;
import com.applets.university.sys.vo.CarouselVO;
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
 * @since 2021-08-11
 */
@RestController
@RequestMapping("/sys/carousel")
@Api(tags = "轮播图")
public class CarouselController {

    @Autowired
    private ICarouselService carouselService;

    @GetMapping
    @ApiOperation("遍历轮播图")
    private AjaxResult listCarousel() {
        LambdaQueryWrapper<Carousel> wrapper = new LambdaQueryWrapper<Carousel>()
                .orderByAsc(Carousel::getSort);
        List<Carousel> carouselList = carouselService.list(wrapper);
        List<CarouselVO> carouselVOList = SysConverter.INSTANCE.toCarouselVOList(carouselList);
        return AjaxResult.success(carouselVOList);
    }

}
