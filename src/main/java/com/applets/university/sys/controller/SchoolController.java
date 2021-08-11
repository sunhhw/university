package com.applets.university.sys.controller;


import com.applets.university.common.api.AjaxResult;
import com.applets.university.sys.converter.SysConverter;
import com.applets.university.sys.entity.School;
import com.applets.university.sys.service.ISchoolService;
import com.applets.university.sys.vo.SchoolVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author shw
 * @since 2021-08-10
 */
@RestController
@RequestMapping("/sys/school")
@Api(tags = "学校")
public class SchoolController {

    @Autowired
    private ISchoolService schoolService;

    @ApiOperation("遍历所有学校")
    @GetMapping
    private AjaxResult listSchool() {
        List<School> list = schoolService.list();
        List<SchoolVO> schoolVOList = SysConverter.INSTANCE.toSchoolVOList(list);
        return AjaxResult.success(schoolVOList);
    }


}
