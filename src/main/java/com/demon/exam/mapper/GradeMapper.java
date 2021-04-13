package com.demon.exam.mapper;

import com.demon.exam.pojo.GradeInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName GradeMapper
 * @Descriotion 年级
 * @Author Demon
 * @Date 2020/11/28 23:35
 **/
public interface GradeMapper extends Mapper<GradeInfo> {

    @Select("SELECT gradeId FROM gradeinfo WHERE gradeName = #{gradeName}")
    List<GradeInfo> queryByGradeName(@Param("gradeName") String gradeName);

}
