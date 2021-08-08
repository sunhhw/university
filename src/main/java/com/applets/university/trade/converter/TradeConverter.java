package com.applets.university.trade.converter;

import com.applets.university.trade.entity.Trade;
import com.applets.university.trade.entity.TradeImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @auther 85028
 * @date 2021/8/2
 */
@Mapper
public interface TradeConverter {

    TradeConverter INSTANCE = Mappers.getMapper(TradeConverter.class);

    @Mappings({
            @Mapping(target = "typeId", source = "typeId"),
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "detail", source = "detail"),
            @Mapping(target = "openId", source = "openId"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "originalPrice", source = "originalPrice"),
            @Mapping(target = "status", source = "status")
            }
    )
    Trade toTransaction(Integer typeId, String title, String detail,
                        String openId, Double price, Double originalPrice, Integer status);

    @Mappings({
            @Mapping(target = "tradeId", source = "tradeId"),
            @Mapping(target = "path", source = "path"),
            }
    )
    TradeImage toTradeImage(Integer tradeId, String path);

}
