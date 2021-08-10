package com.applets.university.trade.dto;

import com.applets.university.common.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther shw
 * @date 2021/8/10
 */
@Data
public class TradeParamDto extends PageDto {

    @ApiModelProperty("学校id")
    private Integer schoolId;

    @ApiModelProperty("关键字")
    private String keyWord;

}
