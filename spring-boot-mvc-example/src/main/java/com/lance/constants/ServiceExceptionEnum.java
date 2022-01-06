package com.lance.constants;

public enum ServiceExceptionEnum {

    SUCCESS(0, "Success"),
    SYS_ERROR(2001001000, "Server error"),
    MISSING_REQUEST_PARAM_ERROR(2001001001, "Missing parameter"),
    USER_NOT_FOUND(1001002000, "User not found");

    private int code;
    private String message;

    ServiceExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
