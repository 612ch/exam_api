package com.demon.exam.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 年级信息
 *
 * @author Demon
 * @date 2020/11/28
 */
@Table(name = "gradeinfo")
@Data
public class GradeInfo  implements Serializable {
    /**
     * 年级编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gradeId")
    private Integer gradeId;
    /**
     * 年级名称
     */
    @Column(name = "gradeName")
    private String gradeName;
}