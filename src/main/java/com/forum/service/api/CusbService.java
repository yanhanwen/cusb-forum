package com.forum.service.api;

import com.forum.entity.User;

import java.util.List;

public interface CusbService {
    int login(String userName,String userPwd);
    int logout(String userId);
    int regist(User user);
    List<User> getActiveUserList();
}
