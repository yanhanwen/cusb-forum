package com.forum.service.api;

public interface CusbService {
    int login(String userName,String userPwd);
    void logout();
    int regist(String userId,String userPwd);
}
