package com.forum.service.impl;

import com.forum.common.ForumException;
import com.forum.common.ForumResultCode;
import com.forum.dao.ForumMapper;
import com.forum.dao.UserMapper;
import com.forum.entity.Forum;
import com.forum.entity.User;
import com.forum.service.api.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    UserMapper userDao;
    @Autowired
    ForumMapper forumDao;

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
    @Override
    public void adminAddForum(Forum forum ){
        forumDao.insert(forum);
    }

    /*管理员删除分论坛*/
    @Override
    public void adminDeleteForum(String forumId){
        forumDao.deleteByPrimaryKey(forumId);
    }

    /*管理员修改分论坛*/
    @Override
    public void adminChangeForum(Forum forum){
        forumDao.updateByPrimaryKey(forum);
    }

    /*管理员查询分论坛*/
    @Override
    public Forum adminSearchForum(String forumName){
        Forum forum=forumDao.selectByPrimaryKey(forumName);
        return forum;
    }




}
