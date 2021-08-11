package com.applets.university.trade.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @auther shw
 * @date 2021/8/9
 */
@Data
@ApiModel(value="Trade对象", description="商品详情")
public class TradeInfoVO extends TradeVO {

    @ApiModelProperty(value = "封面图片集合")
    private List<String> coverPathList;


}
