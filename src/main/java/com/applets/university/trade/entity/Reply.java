package com.applets.university.trade.entity;

import com.applets.university.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 回复
 * </p>
 *
 * @author shw
 * @since 2021-08-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Reply对象", description="回复")
public class Reply extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论id")
    private Integer commentId;

    @ApiModelProperty(value = "用户id")
    private String openId;

    @ApiModelProperty(value = "内容")
    private String content;

}
