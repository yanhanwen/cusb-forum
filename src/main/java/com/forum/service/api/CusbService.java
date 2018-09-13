package com.forum.service.api;

import com.forum.entity.User;

import java.util.List;

public interface CusbService {
    /*
     **登陆
     */
    int login(String userName,String userPwd);

    /*
     **注销
     */
    int logout(String userId);

    /*
     **注册
     */
    int regist(User user);

    /*
     **获得登陆状态用户
     */
    List<User> getActiveUserList();

    /*
     **发文章
     */
    int faPost(String userId,String forumId,String postName);

    /*
     **发回帖楼层
     */
    int replyPost(String userId,String postId,String floorText);
}
