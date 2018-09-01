package com.forum.common;

public enum ForumResultCode implements ResultCode{
    //sucess
    SUCCESS(0, "成功"),
    //fail
    FAIL(4000, "失败"),

    /**unknown error*/
    SERVER_ERROR(99999999, "系统处理错误"),
    SYS_IO_ERROR(20000001, "系统文件错误"),

    /**参数错误*/
    PARAM_MISS(20010001, "缺少必要参数"),

    /**param invalid*/
    PARAM_INVALID(20010002, "参数格式错误"),//param invalid

    //数据
    DB_STORE(40000001, "数据库未找到对应记录");

    private int code;
    private String message;

    ForumResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessage(int code) {
        for (ForumResultCode banksResultCode : ForumResultCode.values()) {
            if (banksResultCode.getCode() == code) {
                return banksResultCode.getMessage();
            }
        }
        return null;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
