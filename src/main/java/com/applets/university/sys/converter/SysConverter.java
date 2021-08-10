package com.applets.university.sys.converter;

import com.applets.university.sys.entity.School;
import com.applets.university.trade.vo.SchoolVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * auther 85028
 *
 * @date 2021/8/2
 */
@Mapper
public interface SysConverter {

    SysConverter INSTANCE = Mappers.getMapper(SysConverter.class);

    SchoolVO toSchoolVo(School school);

    List<SchoolVO> toSchoolVOList(List<School> schoolList);

}
