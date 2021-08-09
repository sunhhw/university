package com.applets.university.trade.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther shw
 * @date 2021/8/9
 */
@Data
public class DictVo {

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "字典代码")
    private Integer code;

}
