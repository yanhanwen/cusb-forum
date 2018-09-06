package com.forum.service.api;

public interface CusbService {
    int login(String userName,String userPwd);
    void logout();
    void regist();
}
