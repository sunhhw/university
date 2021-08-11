package com.applets.university.trade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @auther shw
 * @date 2021/8/11
 *
 */
@Data
@ApiModel(value="Comment对象", description="评论")
public class CommentParamDto {

    @ApiModelProperty(value = "动态id")
    @NotNull(message = "动态id不可为空")
    private Integer dynamicId;

    @ApiModelProperty(value = "模块")
    @NotBlank(message = "模块不可为空")
    private String module;

    @ApiModelProperty(value = "内容")
    @NotBlank(message = "内容不可为空")
    private String content;

}
