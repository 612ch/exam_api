package com.demon.exam.pojo;

import lombok.Data;

/**
 * @ClassName ExamHistoryPaper
 * @Descriotion 考试历史
 * @Author demon
 * @Date 2019/5/28 0:06
 * @Version 1.0
 **/
@Data
public class ExamHistoryPaper {

    private int examScore;

    private String beginTime;

    private Integer examPaperId;
    private String examPaperName;
    private int subjectNum;
    private int examPaperScore;

}
