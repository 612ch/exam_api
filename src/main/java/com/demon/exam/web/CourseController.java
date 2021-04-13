package com.demon.exam.web;

import com.demon.exam.enums.ExceptionEnum;
import com.demon.exam.pojo.CourseInfo;
import com.demon.exam.service.CourseService;
import com.demon.exam.vo.ExceptionResult;
import com.demon.exam.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CourseController
 * @Descriotion 科目控制器
 * @Author Demon
 * @Date 2020/11/29 19:01
 **/

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseService courseService;

    /**
     * 分页查询科目
     * @param pageIndex
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<CourseInfo>> queryCourseByPage(
            @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "search", required = false) String search
    ) {
        PageResult<CourseInfo> result = courseService.queryCourseByPage(pageIndex, pageSize,search);
        return ResponseEntity.ok(result);
    }

    /**
     * 新增科目
     * @param division
     * @param gradeId
     * @param courseName
     * @return
     */
    @PostMapping
    public ResponseEntity<ExceptionResult> saveCourse(
            @RequestParam(value = "division", required = false, defaultValue = "0") Integer division,
            @RequestParam(value = "gradeId", required = false, defaultValue = "1") Integer gradeId,
            @RequestParam(value = "courseName", required = false, defaultValue = "新添加班级") String courseName
    ){
        CourseInfo course=new CourseInfo(null,courseName,division,null,gradeId);
        courseService.saveCourse(course);
        return ResponseEntity.status(ExceptionEnum.CREATED.getCode()).body(new ExceptionResult(ExceptionEnum.CREATED));
    }

    /**
     * 修改科目
     * @param courseId
     * @param division
     * @param gradeId
     * @param courseName
     * @return
     */
    @PutMapping
    public ResponseEntity<ExceptionResult> updateCourse(
            @RequestParam(value = "courseId", required = false) Integer courseId,
            @RequestParam(value = "division", required = false) Integer division,
            @RequestParam(value = "gradeId", required = false) Integer gradeId,
            @RequestParam(value = "courseName", required = false) String courseName
    ){
        CourseInfo course=new CourseInfo(courseId,courseName,division,null,gradeId);
        courseService.updateCourse(course);
        return ResponseEntity.status(ExceptionEnum.SAVED.getCode()).body(new ExceptionResult(ExceptionEnum.SAVED));
    }

    /**
     * 删除科目
     * @param courseId
     * @return
     */
    @DeleteMapping("/{courseId}")
    public ResponseEntity<ExceptionResult> deleteGrade(@PathVariable("courseId") String courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(ExceptionEnum.DELETED.getCode()).body(new ExceptionResult(ExceptionEnum.DELETED));
    }
}
