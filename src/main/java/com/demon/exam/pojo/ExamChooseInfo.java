package com.demon.exam.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "examchooseinfo")
@Data
public class ExamChooseInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chooseId;

    private Integer studentId;
    private StudentInfo student;

    private ExamPaperInfo examPaper;
    private SubjectInfo subject;


    private Integer exampaperId;

    private Integer subjectId;

    private String chooseResult;


}