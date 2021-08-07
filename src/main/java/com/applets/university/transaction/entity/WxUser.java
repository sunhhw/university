package com.applets.university.transaction.entity;

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
 * @since 2021-08-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="WxUser对象", description="")
public class WxUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String nickName;

    @ApiModelProperty(value = "微信账号")
    private String wxCode;

    @ApiModelProperty(value = "手机号")
    private String iphone;

    @ApiModelProperty(value = "所属学校id")
    private Integer schoolId;

    @ApiModelProperty(value = "用户所在程序唯一id")
    private String openId;

    @ApiModelProperty(value = "用户头像")
    private String avatarUrl;

    @ApiModelProperty(value = "0未知 1男 2女")
    private Integer gender;

    @ApiModelProperty(value = "所在省")
    private String province;

    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "所在小程序唯一id")
    private String unionid;

}
