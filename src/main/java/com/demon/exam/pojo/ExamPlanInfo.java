package com.demon.exam.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "examplaninfo")
@Data
public class ExamPlanInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examPlanId;

    private Integer courseId;

    private Integer classId;

    private Integer exampaperId;

    private String beginTime;

    private CourseInfo course;

    private ClassInfo clazz;

    private ExamPaperInfo examPaper;


}