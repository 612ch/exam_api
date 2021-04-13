package com.demon.exam.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "examhistoryinfo")
@Data
public class ExamHistoryInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer historyId;

    private Integer studentId;

    private Integer exampaperId;
    private Integer examPaperTime;


    private Integer examScore;
    private StudentInfo student;
    private ExamPaperInfo examPaper;


}