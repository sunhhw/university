package com.applets.university.trade.entity;

import com.applets.university.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author shw
 * @since 2021-08-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Image对象", description="")
public class TradeImage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图片路径")
    private String path;

    @ApiModelProperty(value = "交易id")
    private Integer tradeId;



}
