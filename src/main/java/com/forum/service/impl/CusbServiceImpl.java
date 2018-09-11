package com.forum.service.impl;

import com.forum.common.ForumException;
import com.forum.common.ForumResultCode;
import com.forum.dao.UserMapper;
import com.forum.entity.Forum;
import com.forum.entity.User;
import com.forum.service.api.CusbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CusbServiceImpl implements CusbService {
    @Autowired
    UserMapper userDao;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public int login(String userId,String userPwd){
        logger.info("start to login scan,userId:{}",userId);
        User user = userDao.selectByPrimaryKey(userId);
        if(user == null){
            logger.error("not find,userId:{}",userId);
            throw new ForumException(ForumResultCode.DB_STORE);
        }
        else{
            if(userPwd == null || !user.getUserPwd().equals(userPwd)){
                logger.error("password wrong,userId:{}",userId);
                return -2;
            }
            user.setStatus(1);//设置为登陆状态
            userDao.updateByPrimaryKey(user);
            return 0;
        }
    }

    @Override
    public int logout(String userId) {
        User user = userDao.selectByPrimaryKey(userId);
        if(user == null){
            logger.error("not found userId:{}",userId);
            throw new ForumException(ForumResultCode.DB_STORE);
        }
        user.setStatus(0);//0为未登录
        try{
            int t = userDao.updateByPrimaryKey(user);
        } catch (Exception e){
            logger.error("logout failed userId:{}",userId);
            return -1;
        }
        return 0;
    }

    @Override
    public int regist(User user) {
        int t = userDao.insert(user);
        if(t == 1){
            logger.info("regist succeed userId:{}",user.getUserId());
            return 0;
        }
        return -1;
    }

    @Override
    public List<User> getActiveUserList() {
        List<User> result;
        result = userDao.selectActive();
        return result;
    }
}
