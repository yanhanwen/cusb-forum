package com.forum.service.impl;

import com.forum.common.ForumException;
import com.forum.common.ForumResultCode;
import com.forum.dao.UserMapper;
import com.forum.entity.User;
import com.forum.service.api.CusbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return -1;
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
    public void logout() {

    }

    @Override
    public int regist(String userId,String userPwd) {
//        userDao.insert();
        return -1;
    }
}
