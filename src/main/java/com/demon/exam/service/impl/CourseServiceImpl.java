package com.demon.exam.service.impl;

import com.demon.exam.enums.ExceptionEnum;
import com.demon.exam.exception.MyException;
import com.demon.exam.mapper.CourseMapper;
import com.demon.exam.mapper.GradeMapper;
import com.demon.exam.pojo.CourseInfo;
import com.demon.exam.pojo.GradeInfo;
import com.demon.exam.service.CourseService;
import com.demon.exam.vo.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CourseServiceImpl
 * @Descriotion 科目服务继承类
 * @Author Demon
 * @Date 2020/11/29 19:02
 **/
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public PageResult<CourseInfo> queryCourseByPage(Integer pageIndex, Integer pageSize, String search) {
        //分页查询
        /*if(-1==pageSize){
            pageSize=999;
        }
        HashMap params =new HashMap();
        Integer startIndex=(pageIndex-1)*pageSize;
        params.put("startIndex",startIndex);
        params.put("pageSize",pageSize);
        params.put("search",search);
        //查询
        List<CourseInfo> list = courseMapper.getAllCourseInfo(params);
        if (CollectionUtils.isEmpty(list)){
            throw new MyException(ExceptionEnum.COURSE_NOT_FOUNT);
        }else{
            //查询所有年级
            List<GradeInfo> gradeInfos = gradeMapper.selectAll();
            HashMap<Integer,GradeInfo> map=new HashMap<>();
            for(GradeInfo gradeInfo:gradeInfos){
                map.put(gradeInfo.getGradeId(),gradeInfo);
            }
            for (int i = 0; i <list.size() ; i++) {
                list.get(i).setGrade(map.get(list.get(i).getGradeId()));
            }
        }*/
        //分页查询
        //分页查询
        if(-1==pageSize){
            pageSize=999;
        }
        PageHelper.startPage(pageIndex,pageSize);
        //过滤
        Example example = new Example(CourseInfo.class);
        if (StringUtils.isNotBlank(search)){
            //过滤条件
            example.createCriteria().orLike("courseName", "%" + search + "%");
        }
        //查询
        List<CourseInfo> list = courseMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            throw new MyException(ExceptionEnum.COURSE_NOT_FOUNT);
        }else{
            //查询所有年级
            List<GradeInfo> gradeInfos = gradeMapper.selectAll();
            HashMap<Integer,GradeInfo> map=new HashMap<>();
            for(GradeInfo gradeInfo:gradeInfos){
                map.put(gradeInfo.getGradeId(),gradeInfo);
            }
            for (int i = 0; i <list.size() ; i++) {
                list.get(i).setGrade(map.get(list.get(i).getGradeId()));
            }
        }
        //解析分页结果
        PageInfo<CourseInfo> pageInfo = new PageInfo<>(list);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), list);
    }

    @Override
    public void saveCourse(CourseInfo course) {
        //判断是否存在
        List<CourseInfo> grade= courseMapper.queryByCourseName(course.getCourseName());
        if (null!=grade&&grade.size()>0){
            throw new MyException(ExceptionEnum.COURSE_ALREADY_EXISTS);
        }
        int count=courseMapper.insert(course);
        if(count!=1){
            throw  new MyException(ExceptionEnum.GRADE_SAVE_ERROR);
        }
    }

    @Override
    public void updateCourse(CourseInfo course) {
        int i=courseMapper.updateByPrimaryKey(course);
        if(0==i){
            throw  new MyException(ExceptionEnum.COURSE_SAVE_ERROR);
        }
    }

    @Override
    public void deleteCourse(String courseId) {
        //判断年级下是否有科目
        List<CourseInfo> list=courseMapper.getSubjectByCourseId(courseId);
        if (null!=list&&list.size()>0){
            throw new MyException(ExceptionEnum.GRADE_DELETE_ERROR);
        }
        int i =courseMapper.deleteByPrimaryKey(courseId);
        if(0==i){
            throw new MyException(ExceptionEnum.GRADE_DELETE_ERROR);
        }
    }
}
