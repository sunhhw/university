package com.applets.university.trade.entity;

import com.applets.university.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class Image extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图片路径")
    private String path;

    @ApiModelProperty(value = "动态id")
    private Integer dynamicId;

    @ApiModelProperty(value = "是否为封面，1是，0否")
    @TableField("is_cover")
    private Integer cover;

    @ApiModelProperty(value = "模块类型 二手交易：trade")
    private String module;


}
