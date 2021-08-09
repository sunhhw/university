package com.applets.university.trade.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther shw
 * @date 2021/8/9
 */
@Data
public class TradeVo {

    private Integer id;

    @ApiModelProperty(value = "分类")
    private String type;

    @ApiModelProperty(value = "详情")
    private String detail;

    @ApiModelProperty(value = "现价")
    private Double price;

    @ApiModelProperty(value = "原价")
    private Double originalPrice;

    @ApiModelProperty(value = "成色")
    private String fineness;

    @ApiModelProperty(value = "封面图片")
    private String coverPath;


}
