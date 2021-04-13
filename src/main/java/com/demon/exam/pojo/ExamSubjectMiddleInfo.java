package com.demon.exam.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name = "examsubjectmiddleinfo")
@Data
public class ExamSubjectMiddleInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer esmId;
    private ExamPaperInfo examPaper;
    private SubjectInfo subject;
}