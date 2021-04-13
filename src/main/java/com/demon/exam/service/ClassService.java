package com.demon.exam.service;

import com.demon.exam.pojo.ClassInfo;
import com.demon.exam.vo.ClassNumVO;
import com.demon.exam.vo.PageResult;

import java.util.List;

/**
 * @ClassName ClassService
 * @Descriotion 班级服务
 * @Author Demon
 * @Date 2020/11/28 23:19
 **/
public interface ClassService {
    /**
     * 分页查询班级
     * @param pageIndex
     * @param pageSize
     * @param search
     * @return
     */
    PageResult<ClassInfo> queryClassByPage(Integer pageIndex, Integer pageSize, String search);

    /**
     * 查询嗝班级人数统计
     * @param classId 可为空 则查询指定班级
     * @return
     */
    List<ClassNumVO> getStudentCountForClass(String classId);

}
