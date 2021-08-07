package com.applets.university.transaction.controller;

import com.applets.university.common.api.AjaxResult;
import com.applets.university.transaction.converter.SchoolConverter;
import com.applets.university.transaction.entity.School;
import com.applets.university.transaction.service.ISchoolService;
import com.applets.university.transaction.vo.SchoolVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * @param
     * @return
     */
    @GetMapping
    @ApiOperation("获取所有学校列表")
    public AjaxResult listSchool() {
        List<School> schoolList = schoolService.list();
        List<SchoolVO> schoolVOList = SchoolConverter.INSTANCE.toSchoolVo(schoolList);
        return AjaxResult.success(schoolVOList);
    }

    /**
     * 根据学校id获取到同一市的所有学校
     *
     * @param id 学校id
     * @return
     */
    @GetMapping
    @ApiOperation("获取同一市的所有学校")
    public AjaxResult listSchool(Long id) {
        School school = schoolService.getById(id);
        String city = school.getCity();
        List<School> schoolList = schoolService.list(new LambdaQueryWrapper<School>()
                .eq(School::getCity, city));
        List<SchoolVO> schoolVOList = SchoolConverter.INSTANCE.toSchoolVo(schoolList);
        return AjaxResult.success(schoolVOList);
    }

}
