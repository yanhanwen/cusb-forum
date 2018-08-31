package com.forum.dao;

import com.forum.entity.User;

public interface UserMapper {
    User selectByUserId(String user_id);

    int deleteByUserId(String user_id);

    int insert(User record);

    int updateByUserId(String user_id);
}
