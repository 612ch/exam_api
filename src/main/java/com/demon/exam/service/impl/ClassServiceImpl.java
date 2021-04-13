package com.demon.exam.service.impl;

import com.demon.exam.enums.ExceptionEnum;
import com.demon.exam.exception.MyException;
import com.demon.exam.mapper.ClassMapper;
import com.demon.exam.mapper.GradeMapper;
import com.demon.exam.mapper.TeacherMapper;
import com.demon.exam.pojo.ClassInfo;
import com.demon.exam.pojo.GradeInfo;
import com.demon.exam.pojo.TeacherInfo;
import com.demon.exam.service.ClassService;
import com.demon.exam.vo.ClassNumVO;
import com.demon.exam.vo.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName ClassServiceImpl
 * @Descriotion 班级服务
 * @Author Demon
 * @Date 2020/11/28 23:20
 **/
@Slf4j
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public PageResult<ClassInfo> queryClassByPage(Integer pageIndex, Integer pageSize, String search) {
        // 分页
        if(-1==pageSize){
            pageSize=999;
        }
        PageHelper.startPage(pageIndex,pageSize);
        // 过滤
        Example example = new Example(ClassInfo.class);
        if (StringUtils.isNotBlank(search)){
            // 过滤条件
            example.createCriteria().orLike("className", "%" + search + "%");
        }
        // 查询
        List<ClassInfo> list = classMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            log.error("班级不存在");
            throw new MyException(ExceptionEnum.CLASS_NOT_FOUNT);
        }else{
            // 查询所有年级
            List<GradeInfo> gradeInfos = gradeMapper.selectAll();
            HashMap<Integer, GradeInfo> map=new HashMap<>();
            for(GradeInfo gradeInfo:gradeInfos){
                map.put(gradeInfo.getGradeId(),gradeInfo);
            }
            for (int i = 0; i <list.size() ; i++) {
                list.get(i).setGrade(map.get(list.get(i).getGradeId()));
            }
            // 查询所有班主任
            List<TeacherInfo> teacherInfos = teacherMapper.selectAll();

            HashMap<Integer, TeacherInfo> tMap=new HashMap<>();
            for(TeacherInfo teacherInfo:teacherInfos){
                tMap.put(teacherInfo.getTeacherId(),teacherInfo);
            }
            for (int i = 0; i <list.size() ; i++) {
                list.get(i).setTeacher(tMap.get(list.get(i).getTeacherId()));
            }
        }
        // 解析分页结果
        PageInfo<ClassInfo> pageInfo = new PageInfo<>(list);

        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), list);
    }

    @Override
    public List<ClassNumVO> getStudentCountForClass(String classId) {
        return classMapper.getStudentCountForClass(classId);
    }
}
