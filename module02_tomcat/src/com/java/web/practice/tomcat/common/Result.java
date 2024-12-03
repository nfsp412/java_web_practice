package com.java.web.practice.tomcat.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name Result
 * @create 2024/12/3 18:52
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> build(T data) {
        Result<T> result = new Result<>();
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    public static <T> Result<T> build(T data, Integer code, String message) {
        Result<T> build = build(data);
        build.setCode(code);
        build.setMessage(message);
        return build;
    }

    public static <T> Result<T> build(T data, ResultCodeEnum codeEnum) {
        Result<T> build = build(data);
        build.setCode(codeEnum.getCode());
        build.setMessage(codeEnum.getMessage());
        return build;
    }

    public static <T> Result<T> ok(T data) {
        Result<T> build = build(data, ResultCodeEnum.SUCCESS);
        return build;
    }
}
