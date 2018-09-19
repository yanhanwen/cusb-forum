package com.forum.service.api;

import com.forum.entity.Forum;
import com.forum.entity.User;

import java.util.List;

public interface ManagerService {
    /*
     **提权
     */
    void upLevel(String userId,int level);

    /*管理员增加分论坛*/
    void adminAddForum(Forum forum);

    /*管理员删除分论坛*/
    void adminDeleteForum(String forumId);

    /*管理员修改分论坛*/
    void adminChangeForum(Forum forum);

    /*管理员查询分论坛*/
    Forum adminSearchForum(String forumName);



    //增加用户
    int addUser(User user);
    //删除用户
    int deleteUser(String userId);
    //查找用户
    User queryUser(String userId);
    //获得所有用户
    List<User> getAllUser();
    //指定版主
    void designatedModerator(String userId);

    //获得封查列表 1表示临时封查，2表示永久封查
    List<User> getSealList();

}
