package com.demon.exam.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "exampaperinfo")
@Data
public class ExamPaperInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examPaperId;

    private String examPaperName;

    private Integer subjectNum;

    private Integer examPaperTime;

    private Integer examPaperScore;

    private Integer gradeId;

    private GradeInfo grade;

    private Integer division;

    private Integer examPaperEasy;


}