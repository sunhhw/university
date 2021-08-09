package com.applets.university.trade.converter;

import com.applets.university.trade.entity.Dict;
import com.applets.university.trade.entity.Image;
import com.applets.university.trade.entity.Trade;
import com.applets.university.trade.vo.DictVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @auther 85028
 * @date 2021/8/2
 */
@Mapper
public interface TradeConverter {

    TradeConverter INSTANCE = Mappers.getMapper(TradeConverter.class);

    @Mappings({
            @Mapping(target = "typeId", source = "typeId"),
            @Mapping(target = "detail", source = "detail"),
            @Mapping(target = "openId", source = "openId"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "originalPrice", source = "originalPrice"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "finenessId", source = "finenessId")
    }
    )
    Trade toTrade(Integer typeId, String detail, String openId, Double price,
                  Double originalPrice, Integer status, Integer finenessId);

    @Mappings({
            @Mapping(target = "activityId", source = "activityId"),
            @Mapping(target = "path", source = "path"),
            @Mapping(target = "cover", source = "cover"),
            @Mapping(target = "module", source = "module")
    }
    )
    Image toImage(Integer activityId, String path, Integer cover, String module);


    List<DictVo> toDictVoList(List<Dict> dictList);

}
