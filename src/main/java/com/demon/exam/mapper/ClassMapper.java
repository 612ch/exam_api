package com.demon.exam.mapper;

import com.demon.exam.pojo.ClassInfo;
import com.demon.exam.vo.ClassNumVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName ClassMapper
 * @Descriotion 班级
 * @Author Demon
 * @Date 2020/11/28 23:19
 **/
public interface ClassMapper extends Mapper<ClassInfo> {

    List<ClassNumVO> getStudentCountForClass(String classId);

}
