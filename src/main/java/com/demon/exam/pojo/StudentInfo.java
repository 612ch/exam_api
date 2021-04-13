package com.demon.exam.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "studentinfo")
@Data
public class StudentInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String studentName;

    private String studentAccount;

    private String studentPwd;

    private String salt;

    private Integer classId;

    private ClassInfo classInfo;

    private GradeInfo grade;

    private int examCount;

    private String examPaperName;

    private int examScore;

    public String getExamPaperName() {
        return examPaperName;
    }


}