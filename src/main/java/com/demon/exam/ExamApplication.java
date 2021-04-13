package com.demon.exam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@Slf4j
@SpringBootApplication
@MapperScan("com.demon.exam.mapper")
public class ExamApplication {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        SpringApplication.run(ExamApplication.class, args);
        long endTime = System.currentTimeMillis(); //获取结束时间
        log.info("欢迎使用---->在线考试系统");
        log.info("运行耗时---->{}ms" , (endTime - startTime));
        log.info("一分耕耘---->一分收获");
    }

}
