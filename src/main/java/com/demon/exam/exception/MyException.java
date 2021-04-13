package com.demon.exam.exception;

import com.demon.exam.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ClassName MyException
 * @Descriotion 自定义异常处理
 * @Author Demon
 * @Date 2020/11/29 0:06
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MyException extends RuntimeException {
    private ExceptionEnum exceptionEnum;
}
