package com.applets.university.transaction.converter;

import com.applets.university.transaction.entity.School;
import com.applets.university.transaction.vo.SchoolVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @auther 85028
 * @date 2021/8/2
 */
@Mapper
public interface SchoolConverter {

    SchoolConverter INSTANCE = Mappers.getMapper(SchoolConverter.class);

    SchoolVO toSchool(School school);
    /**
     * 转换到 SchoolVo
     * @param schoolList
     * @return
     */
    List<SchoolVO> toSchoolVo(List<School> schoolList);

}
