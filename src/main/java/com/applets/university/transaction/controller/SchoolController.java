package com.applets.university.transaction.controller;

import com.applets.university.common.api.AjaxResult;
import com.applets.university.transaction.converter.SchoolConverter;
import com.applets.university.transaction.entity.School;
import com.applets.university.transaction.service.ISchoolService;
import com.applets.university.transaction.vo.SchoolVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @auther 85028
 * @date 2021/8/2
 */
@RequestMapping("/transaction/school")
@RestController
@Api(value = "高校信息")
public class SchoolController {

    @Autowired
    private ISchoolService schoolService;

    /**
     * 获取学校列表
     *
     * @param id 学校id
     * @return
     */
    @GetMapping
    public AjaxResult listSchool(Long id) {
        List<School> schoolList = new ArrayList<>();
        if (Objects.isNull(id)) {
            schoolList = schoolService.list();
        } else {
            School school = schoolService.getById(id);
            String city = school.getCity();
            schoolList = schoolService.list(new LambdaQueryWrapper<School>()
                    .eq(School::getCity, city));
        }
        List<SchoolVo> schoolVoList = SchoolConverter.INSTANCE.toSchoolVo(schoolList);
        return AjaxResult.success(schoolVoList);
    }

}
