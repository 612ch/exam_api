package com.demon.exam.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Table(name = "teacherinfo")
@Data
public class TeacherInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacherId")
    private Integer teacherId;

    @Column(name = "teacherName")
    private String teacherName;

    @Column(name = "teacherAccount")
    private String teacherAccount;

    @JsonIgnore
    @Column(name = "teacherPwd")
    private String teacherPwd;

    @JsonIgnore
    @Column(name = "salt")
    private String salt;

    @Column(name = "adminPower")
    private Integer adminPower;

    @Column(name = "isWork")
    private Integer isWork;

    @JsonIgnore
    @Transient
    private ClassInfo classInfo;

}