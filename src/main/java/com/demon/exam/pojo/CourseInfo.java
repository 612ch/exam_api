package com.demon.exam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 科目信息
 *
 * @author Demon
 * @date 2020/11/29
 */
@Table(name = "courseinfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseInfo implements Serializable {
    /**
     * 科目编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseId")
    private Integer courseId;
    /**
     * 科目名称
     */
    @Column(name = "courseName")
    private String courseName;
    /**
     * 分科情况
     */
    @Column(name = "division")
    private Integer division;
    /**
     * 所属年级
     */
    @Transient
    private GradeInfo grade;
    /**
     * 年级编号
     */
    @Column(name = "gradeId")
    private  Integer  gradeId;


}