package com.demon.exam.vo;

import com.demon.exam.enums.ExceptionEnum;
import lombok.Data;

@Data
public class ExceptionResult {
    private String timestamp;
    private int code;
    private String error;
    private String msg;


    public ExceptionResult(ExceptionEnum em) {
        this.code = em.getCode();
        this.error = em.getReasonPhrase();
        this.msg = em.getMsg();
        this.timestamp = Long.toString(System.currentTimeMillis());
    }
}