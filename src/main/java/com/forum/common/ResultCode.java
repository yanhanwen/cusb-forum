package com.forum.common;

public interface ResultCode {

    /**
     * 返回结果数值代码
     * @return
     */
    int getCode();

    /**
     * 结果提示信息
     * @return
     */
    String getMessage();
}