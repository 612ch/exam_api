package com.demon.exam.advice;

import com.demon.exam.exception.MyException;
import com.demon.exam.vo.ExceptionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(MyException.class)
    public ResponseEntity<ExceptionResult> handleException(MyException e) {
        //此处日志无法快速定义错误故注释
        /*if (null != e.getExceptionEnum()) {
            log.warn("异常:{}", e.getExceptionEnum().getMsg());
        } else {
            log.warn("异常:{}", e);
        }*/
        //所有异常HTTP状态码均为200
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ExceptionResult(e.getExceptionEnum()));
    }
}