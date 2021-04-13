package com.demon.exam.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


/**
 * 班级信息
 *
 * @author demon
 * @date 2020/11/28
 */
@Table(name = "classinfo")
@Data
public class ClassInfo  implements Serializable {
    /**
     * 班级编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classId")
    private Integer classId;

    /**
     * 班级名称
     */
    @Column(name = "className")
    private String className;

    /**
     * 年级
     */
    @Transient
    private GradeInfo grade;

    /**
     * 教师
     */
    @Transient
    private TeacherInfo teacher;

    /**
     * 年级编号
     */
    @Column(name = "gradeId")
    private Integer gradeId;

    /**
     * 教师编号
     */
    @Column(name = "teacherId")
    private Integer teacherId;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClassInfo{");
        sb.append("classId=").append(classId);
        sb.append(", className='").append(className).append('\'');
        sb.append(", grade=").append(grade);
        sb.append(", teacher=").append(teacher);
        sb.append(", gradeId=").append(gradeId);
        sb.append(", teacherId=").append(teacherId);
        sb.append('}');
        return sb.toString();
    }
}