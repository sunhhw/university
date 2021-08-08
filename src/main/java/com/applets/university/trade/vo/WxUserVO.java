package com.applets.university.trade.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther 85028
 * @date 2021/8/5
 */
@Data
public class WxUserVO {

    @ApiModelProperty(value = "微信昵称")
    private String nickName;

    @ApiModelProperty(value = "手机号")
    private String iphone;

    @ApiModelProperty(value = "所属学校id")
    private Integer schoolId;

    @ApiModelProperty(value = "所属学校名称")
    private Integer schoolName;

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

}
