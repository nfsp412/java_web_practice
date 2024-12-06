package com.java.web.practice.tomcat.common;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name ResultCodeEnum
 * @create 2024/12/3 18:54
 */

public enum ResultCodeEnum {
    SUCCESS(200, "success"),
    USERNAME_ERROR(501, "username_error"),
    PASSWORD_ERROR(503, "password_error"),
    NOT_LOGIN(504, "not_login"),
    USERNAME_USED(505, "username_used");
    private Integer code;
    private String message;

    private ResultCodeEnum() {
    }

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
