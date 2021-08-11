package com.applets.university.sys.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther shw
 * @date 2021/8/11
 */
@Data
@ApiModel(value="Carousel对象", description="轮播图")
public class CarouselVO {

    private Integer id;

    @ApiModelProperty(value = "跳转路径")
    private String url;

    @ApiModelProperty(value = "图片路径")
    private String imagePath;

    @ApiModelProperty(value = "排序")
    private Integer sort;

}
