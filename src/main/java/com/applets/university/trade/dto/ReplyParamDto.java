package com.applets.university.trade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 回复
 * </p>
 *
 * @author shw
 * @since 2021-08-11
 */
@Data
@ApiModel(value="Reply对象", description="回复")
public class ReplyParamDto {

    @ApiModelProperty(value = "评论id")
    @NotNull(message = "评论id不可为空")
    private Integer commentId;

    @ApiModelProperty(value = "内容")
    @NotBlank(message = "内容不可为空")
    private String content;

}
