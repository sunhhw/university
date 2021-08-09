package com.applets.university.trade.entity;

import com.applets.university.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 二手交易-发布
 * </p>
 *
 * @author shw
 * @since 2021-08-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Trade对象", description="二手交易-发布")
public class Trade extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类")
    private Integer typeId;

    @ApiModelProperty(value = "详情")
    private String detail;

    @ApiModelProperty(value = "现价")
    private Double price;

    @ApiModelProperty(value = "原价")
    private Double originalPrice;

    @ApiModelProperty(value = "用户openId")
    private String openId;

    @ApiModelProperty(value = "0下架，1上架")
    private Integer status;

    @ApiModelProperty(value = "成色ID")
    private Integer finenessId;


}
