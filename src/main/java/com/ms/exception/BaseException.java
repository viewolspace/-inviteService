package com.ms.exception;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -5260479364532006348L;
    private String code;
    private String message;

    public BaseException() {
    }

    public BaseException(String code) {
        this.code = code;
        this.setMessage(this.message);
    }

    public BaseException(String code, String message) {
        this.code = code;
        this.setMessage(message);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}