package com.forum.common;

public class ForumResult<T> {

    private int code;
    private String message;
    private T data;

    public ForumResult() {
    }

    public ForumResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ForumResult(ForumResultCode fr) {
        this(fr.getCode(), fr.getMessage(), null);
    }

    public ForumResult(ForumResultCode fr, String paramName) {
        this(fr.getCode(), paramName + ":" + fr.getMessage(), null);
    }

    public ForumResult(T value) {
        this(ForumResultCode.SUCCESS, value);
    }

    public ForumResult(ForumResultCode fr, T value) {
        this(fr);
        this.data = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
