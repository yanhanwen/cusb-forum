package com.forum.service.impl;

import com.forum.common.ForumException;
import com.forum.common.ForumResultCode;
import com.forum.dao.UserMapper;
import com.forum.entity.User;
import com.forum.service.api.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerServiceImpl implements ManagerService {
    @Autowired
    UserMapper userDao;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void upLevel(String userId,int level) {
        User user = userDao.selectByPrimaryKey(userId);
        if(user == null){
            logger.error("not found userId:{}",userId);
            throw new ForumException(ForumResultCode.DB_STORE);
        }
        user.setLevel(level);
        userDao.updateByPrimaryKey(user);
    }
}
