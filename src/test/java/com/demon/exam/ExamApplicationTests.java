package com.demon.exam;

import com.demon.exam.pojo.ClassInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExamApplicationTests {

    @Test
    void contextLoads() {
        ClassInfo classInfo=new ClassInfo();
        System.out.println(classInfo);
    }

}
