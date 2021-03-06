package com.applets.university.trade.converter;

import com.applets.university.trade.dto.CommentParamDto;
import com.applets.university.trade.dto.ReplyParamDto;
import com.applets.university.trade.entity.*;
import com.applets.university.trade.vo.DictVO;
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
            @Mapping(target = "categoryId", source = "categoryId"),
            @Mapping(target = "detail", source = "detail"),
            @Mapping(target = "openId", source = "openId"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "originalPrice", source = "originalPrice"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "finenessId", source = "finenessId"),
            @Mapping(target = "schoolId", source = "schoolId")
    }
    )
    Trade toTrade(Integer categoryId, String detail, String openId, Double price,
                  Double originalPrice, Integer status, Integer finenessId, Integer schoolId);

    @Mappings({
            @Mapping(target = "dynamicId", source = "dynamicId"),
            @Mapping(target = "path", source = "path"),
            @Mapping(target = "cover", source = "cover"),
            @Mapping(target = "module", source = "module")
    }
    )
    Image toImage(Integer dynamicId, String path, Integer cover, String module);


    List<DictVO> toDictVoList(List<Dict> dictList);

    @Mapping(target = "openId", source = "openId")
    Comment toComment(CommentParamDto paramDto,String openId);

    @Mapping(target = "openId", source = "openId")
    Reply toReply(ReplyParamDto paramDto, String openId);

}
