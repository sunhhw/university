package com.applets.university.trade.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther 85028
 * @date 2021/8/2
 */
@Data
public class SchoolVO {

    @ApiModelProperty(value = "学校ID")
    private Long id;

    @ApiModelProperty(value = "学校名称")
    private String name;

}
