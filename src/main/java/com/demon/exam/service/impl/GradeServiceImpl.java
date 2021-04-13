package com.demon.exam.service.impl;

import com.demon.exam.enums.ExceptionEnum;
import com.demon.exam.exception.MyException;
import com.demon.exam.mapper.CourseMapper;
import com.demon.exam.mapper.GradeMapper;
import com.demon.exam.pojo.CourseInfo;
import com.demon.exam.pojo.GradeInfo;
import com.demon.exam.service.GradeService;
import com.demon.exam.vo.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName GradeServiceImpl
 * @Descriotion 年级服务
 * @Author Demon
 * @Date 2020/11/28 23:39
 **/
@Slf4j
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public PageResult<GradeInfo> queryGradeByPage(Integer pageIndex, Integer pageSize, String search) {
        //分页
        if(-1==pageSize){
            pageSize=999;
        }
        PageHelper.startPage(pageIndex,pageSize);
        //过滤
        Example example = new Example(GradeInfo.class);
        if (StringUtils.isNotBlank(search)){
            //过滤条件
            example.createCriteria().orLike("gradeName", "%" + search + "%");
        }
        //排序
        /*if (StringUtils.isNotBlank(sortBy)) {
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }*/
        // 查询
        List<GradeInfo> list = gradeMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            log.warn("查询失败:{}",ExceptionEnum.GRADE_NOT_FOUNT.getMsg());
            throw new MyException(ExceptionEnum.GRADE_NOT_FOUNT);
        }
        //解析分页结果
        PageInfo<GradeInfo> pageInfo = new PageInfo<>(list);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), list);
    }

    @Override
    public void saveGrade(String gradeName) {
        //判断是否存在
        List<GradeInfo> grade= gradeMapper.queryByGradeName(gradeName);
        if (null!=grade&&grade.size()>0){
            log.warn("新增失败:{}",ExceptionEnum.GRADE_ALREADY_EXISTS.getMsg());
            throw new MyException(ExceptionEnum.GRADE_ALREADY_EXISTS);
        }
        GradeInfo info=new GradeInfo();
        info.setGradeName(gradeName);
        int count=gradeMapper.insert(info);
        if(count!=1){
            log.error("新增失败:{}",ExceptionEnum.GRADE_SAVE_ERROR.getMsg());
            throw  new MyException(ExceptionEnum.GRADE_SAVE_ERROR);
        }
    }

    @Override
    public void updateGrade(GradeInfo gradeInfo) {
        int i=gradeMapper.updateByPrimaryKey(gradeInfo);
        if(0==i){
            log.error("修改失败:{}",ExceptionEnum.GRADE_SAVE_ERROR.getMsg());
            throw  new MyException(ExceptionEnum.GRADE_SAVE_ERROR);
        }
    }
    @Override
    public void deleteGrade(String gradeId) {
        //判断年级下是否有科目
        List<CourseInfo> list=courseMapper.getCourseByGradeId(gradeId);
        if (null!=list&&list.size()>0){
            log.warn("删除失败:{}",ExceptionEnum.GRADE_SAVE_ERROR.getMsg());
            throw new MyException(ExceptionEnum.GRADE_DELETE_ERROR);
        }
        int i = gradeMapper.deleteByPrimaryKey(gradeId);
        if(0==i){
            log.warn("删除失败:{}",ExceptionEnum.GRADE_SAVE_ERROR.getMsg());
            throw new MyException(ExceptionEnum.GRADE_DELETE_ERROR);
        }
    }
}
