package com.applets.university.transaction.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author shw
 * @since 2021-08-02
 */
@Data
@ApiModel(value = "School对象", description = "")
public class School {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学校ID")
    private Long id;

    @ApiModelProperty(value = "学校名称")
    @Excel(name = "学校名称")
    private String name;

    @ApiModelProperty(value = "编号")
    @Excel(name = "学校标识码")
    private String number;

    @ApiModelProperty(value = "所在市")
    @Excel(name = "所在地")
    private String city;

    @ApiModelProperty(value = "区")
    private String area;

    @ApiModelProperty(value = "1本科 2专科")
    @Excel(name = "办学层次", replace = {"本科_1", "专科_2"})
    private Integer level;


}
