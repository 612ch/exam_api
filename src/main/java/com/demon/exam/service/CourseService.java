package com.demon.exam.service;

import com.demon.exam.pojo.CourseInfo;
import com.demon.exam.vo.PageResult;

/**
 * @ClassName CourseService
 * @Descriotion 科目服务
 * @Author Demon
 * @Date 2020/11/29 19:02
 **/
public interface CourseService{

    /**
     * 分页查询
     * @param pageIndex 当前页
     * @param pageSize 显示条数
     * @param search 关键字
     * @return
     */
    PageResult<CourseInfo> queryCourseByPage(Integer pageIndex, Integer pageSize, String search);

    /**
     * 新增科目
     * @param course
     */
    void saveCourse(CourseInfo course);

    /**
     * 修改科目
     * @param course
     */
    void updateCourse(CourseInfo course);

    /**
     * 删除科目
     * @param courseId
     */
    void deleteCourse(String courseId);
}
