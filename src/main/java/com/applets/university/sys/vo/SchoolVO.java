package com.applets.university.sys.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther shw
 * @date 2021/8/10
 */
@Data
@ApiModel(value="School对象", description="学校")
public class SchoolVO {

    @ApiModelProperty(value = "学校ID")
    private Long id;

    @ApiModelProperty(value = "学校名称")
    private String name;

}
