package com.forum.common;

public class ForumException extends RuntimeException{
    private int code;

    public ForumException(){
        super("系统处理错误");
    }

    public ForumException(String message){
        super(message);
    }

    public ForumException(int code, String message){
        super(message);
        this.code = code;
    }

    public ForumException(ResultCode rc){
        this(rc.getCode(), rc.getMessage());
    }

    public ForumException(ResultCode rc, String... args){
        this(rc.getCode(), String.format(rc.getMessage(), args));
    }

    public int getCode(){
        return code;
    }
}
