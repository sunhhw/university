package com.applets.university.trade.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther shw
 * @date 2021/8/9
 */
@Data
public class TradeVO {

    private Integer id;

    @ApiModelProperty(value = "分类")
    private String category;

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

    @ApiModelProperty(value = "学校名称")
    private String schoolName;

    @ApiModelProperty("发布者昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatarUrl;

    @ApiModelProperty("浏览数量")
    private Integer views;


}
