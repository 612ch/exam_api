package com.demon.exam.mapper;

import com.demon.exam.pojo.CourseInfo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CourseMapper
 * @Descriotion 科目
 * @Author Demon
 * @Date 2020/11/29 19:03
 **/
public interface CourseMapper  extends Mapper<CourseInfo>{
    List<CourseInfo> getAllCourseInfo(Map map);

    @Select("SELECT courseId FROM CourseInfo WHERE courseName = #{courseName}")
    List<CourseInfo> queryByCourseName(String courseName);

    @Select("SELECT * FROM CourseInfo a INNER JOIN GradeInfo b ON a.gradeId=b.gradeId and a.gradeId=#{gradeId}")
    List<CourseInfo> getCourseByGradeId(String gradeId);

    @Select("SELECT * FROM subjectinfo a INNER JOIN courseinfo b ON a.courseId=b.courseId and a.courseId=#{courseId} limit 10")
    List<CourseInfo> getSubjectByCourseId(String courseId);
}
