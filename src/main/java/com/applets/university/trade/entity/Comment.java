package com.applets.university.trade.entity;

import com.applets.university.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 评论
 * </p>
 *
 * @author shw
 * @since 2021-08-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Comment对象", description="评论")
public class Comment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "活动id")
    private Integer dynamicId;

    @ApiModelProperty(value = "模块")
    private String module;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "用户id")
    private String openId;

}
