package com.demon.exam.web;

import com.demon.exam.pojo.ClassInfo;
import com.demon.exam.service.ClassService;
import com.demon.exam.vo.ClassNumVO;
import com.demon.exam.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ClassController
 * @Descriotion 班级控制器
 * @Author Demon
 * @Date 2020/11/28 23:21
 **/
@RestController
@RequestMapping("class")
public class ClassController {
    @Autowired
    private ClassService classService;

    /**
     * 班级分页查询
     *
     * @param pageIndex
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<ClassInfo>> queryClassByPage(
            @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "search", required = false) String search
    ) {
        PageResult<ClassInfo> result = classService.queryClassByPage(pageIndex, pageSize, search);
        return ResponseEntity.ok(result);
    }

    /**
     * 学生人数统计
     *
     * @return {@link ResponseEntity<List<ClassNumVO>>}
     */
    @GetMapping("studentNum")
    public ResponseEntity<List<ClassNumVO>> getStudentCountForClass(
            @RequestParam(value = "classId", required = false) String classId
    ) {
        List<ClassNumVO> list = classService.getStudentCountForClass(classId);
        return ResponseEntity.ok(list);
    }

}
