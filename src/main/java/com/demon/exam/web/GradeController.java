package com.demon.exam.web;

import com.demon.exam.enums.ExceptionEnum;
import com.demon.exam.pojo.GradeInfo;
import com.demon.exam.service.GradeService;
import com.demon.exam.vo.ExceptionResult;
import com.demon.exam.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName GradeController
 * @Descriotion 年级控制器
 * @Author Demon
 * @Date 2020/11/28 23:40
 **/
@RestController
@RequestMapping("grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    /**
     * 分页获取年级
     * @param pageIndex 当前页
     * @param pageSize 显示数量
     * @param search 搜索关键字
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<GradeInfo>> queryGradeByPage(
            @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "search", required = false) String search
    ) {
        PageResult<GradeInfo> result = gradeService.queryGradeByPage(pageIndex, pageSize,search);
        return ResponseEntity.ok(result);
    }

    /**
     * 保存年级
     * @param gradeName 年级名称
     * @return
     */
    @PostMapping
    public ResponseEntity<ExceptionResult> saveGrade(@RequestParam(value = "gradeName", required = false)String gradeName){
        gradeService.saveGrade(gradeName);
        return ResponseEntity.status(ExceptionEnum.CREATED.getCode()).body(new ExceptionResult(ExceptionEnum.CREATED));
    }

    /**
     * 修改年级
     * @param gradeInfo 年级对象
     * @return
     */
    @PutMapping
    public ResponseEntity<ExceptionResult> updateGrade(GradeInfo gradeInfo){
        gradeService.updateGrade(gradeInfo);
        return ResponseEntity.status(ExceptionEnum.SAVED.getCode()).body(new ExceptionResult(ExceptionEnum.SAVED));
    }

    /**
     * 删除年级
     * @param gradeId 年级编号
     * @return
     */
    @DeleteMapping("/{gradeId}")
    public ResponseEntity<ExceptionResult> deleteGrade(@PathVariable("gradeId") String gradeId){
        gradeService.deleteGrade(gradeId);
        return ResponseEntity.status(ExceptionEnum.DELETED.getCode()).body(new ExceptionResult(ExceptionEnum.DELETED));
    }


}
