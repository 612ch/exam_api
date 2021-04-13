package com.demon.exam.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 主题信息
 *
 * @author Demon
 * @date 2020/11/29
 */
@Table(name = "subjectinfo")
@Data
public class SubjectInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;

    private String subjectName;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String rightResult;

    private Integer subjectScore;

    private Integer subjectType;

    private Integer courseId;

    private CourseInfo course;

    private Integer gradeId;

    private GradeInfo grade;

    private Integer subjectEasy;

    private Integer division;

}