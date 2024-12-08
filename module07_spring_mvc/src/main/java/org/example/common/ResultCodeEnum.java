package org.example.common;

public enum ResultCodeEnum {
    SUCCESS(200, "success"),
    USERNAME_ERROR(501, "usernameError"),
    PASSWORD_ERROR(503, "passwordError"),
    NOT_LOGIN(504, "notLogin"),
    USERNAME_USED(505, "userNameUsed"),
    PAGE_NUM_ERROR(506, "pageNumError");

    private Integer code;
    private String message;

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
