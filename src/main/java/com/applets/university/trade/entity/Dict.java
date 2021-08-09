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
 * @since 2021-08-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Dict对象", description="字典表")
public class Dict extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "字典代码")
    private Integer code;

    @ApiModelProperty(value = "字段类型")
    private String type;

    @ApiModelProperty(value = "字段排序")
    private Integer sort;

}
