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
 * @since 2021-08-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="School对象", description="")
public class School extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学校名称")
    private String name;


}
