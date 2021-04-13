package com.demon.exam.service;

import com.demon.exam.pojo.GradeInfo;
import com.demon.exam.vo.PageResult;

/**
 * @ClassName GradeService
 * @Descriotion 年级服务
 * @Author Demon
 * @Date 2020/11/28 23:38
 **/
public interface GradeService {
    /**
     * 分页查询年级
     * @param pageIndex 当前页
     * @param pageSize 显示条数
     * @param search 关键字
     * @return
     */
    PageResult<GradeInfo> queryGradeByPage(Integer pageIndex, Integer pageSize, String search);

    /**
     * 保存年级
     * @param gradeName 年级名称
     */
    void saveGrade(String gradeName);

    /**
     * 修改年级
     * @param gradeInfo 年级对象
     */
    void updateGrade(GradeInfo gradeInfo);

    /**
     * 删除年级
     * @param gradeId 年级编号
     */
    void deleteGrade(String gradeId);
}
