package com.applets.university.sys.entity;

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
 * @since 2021-08-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Carousel对象", description="轮播图")
public class Carousel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "跳转路径")
    private String url;

    @ApiModelProperty(value = "图片路径")
    private String imagePath;

    @ApiModelProperty(value = "排序")
    private Integer sort;


}
