package com.demon.exam.web;

import com.demon.exam.pojo.ClassInfo;
import com.demon.exam.vo.PageResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

/**
 * @ClassName ClassControllerTest
 * @Descriotion
 * @Author Demon
 * @Date 2021/3/20 0:07
 **/

@SpringBootTest
class ClassControllerTest {
    @Autowired
    ClassController classController;


    @Test
    void queryClassByPage() {
        ResponseEntity<PageResult<ClassInfo>> pageResultResponseEntity = classController.queryClassByPage(1, 10, null);
        System.out.println(pageResultResponseEntity);
    }

    @Test
    void getStudentCountForClass() {
    }
}