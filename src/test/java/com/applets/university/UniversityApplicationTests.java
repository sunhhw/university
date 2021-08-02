package com.applets.university;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.applets.university.transaction.entity.School;
import com.applets.university.transaction.service.ISchoolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@SpringBootTest
class UniversityApplicationTests {

    @Autowired
    private ISchoolService schoolService;

    /**
     * 导入高校信息
     * @throws Exception
     */
    @Test
    void contextLoads() throws Exception {

        List<School> schoolList = ExcelImportUtil.importExcel(new FileInputStream(
                new File("C:\\Users\\85028\\Desktop\\school.xls")), School.class, new ImportParams());
        schoolService.saveBatch(schoolList);

    }

}
