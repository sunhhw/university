package com.applets.university.sys.converter;

import com.applets.university.sys.entity.Carousel;
import com.applets.university.sys.entity.School;
import com.applets.university.sys.vo.CarouselVO;
import com.applets.university.sys.vo.SchoolVO;
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

    SchoolVO toSchoolVO(School school);

    List<SchoolVO> toSchoolVOList(List<School> schoolList);

    CarouselVO toCarouselVO(Carousel carousel);

    List<CarouselVO> toCarouselVOList(List<Carousel> carouselList);

}
