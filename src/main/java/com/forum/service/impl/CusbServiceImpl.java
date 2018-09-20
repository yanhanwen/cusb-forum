package com.forum.service.impl;

import com.forum.common.ForumException;
import com.forum.common.ForumResultCode;
import com.forum.dao.FloorMapper;
import com.forum.dao.PostMapper;
import com.forum.dao.UserMapper;
import com.forum.entity.*;
import com.forum.service.api.CusbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CusbServiceImpl implements CusbService {
    @Autowired
    UserMapper userDao;
    @Autowired
    PostMapper postDao;
    @Autowired
    FloorMapper floorDao;

    Logger logger = LoggerFactory.getLogger(getClass());

    private Session session;
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
            user.setStatus(211);//设置为登陆状态

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
    public void regist(User user) {
        try{
            int t = userDao.insert(user);
            if(t == 1) {
                logger.info("regist succeed userId:{}", user.getUserId());
            }
        } catch (Exception e) {
            logger.error("regist failed userId:{}", user.getUserId());
            throw new ForumException(ForumResultCode.PARAM_INVALID);
        }
    }

    @Override
    public List<User> getActiveUserList() {
        List<User> result = userDao.selectAll();
        List<User> ans = new ArrayList<>();
        for(User user:result){
            if(user.getStatus()/100 == 2){
                ans.add(user);
            }
        }
        return ans;
    }

    @Override
    public int faPost(String userId,String forumId,String postName){
        Post post = new Post();
        try{
            post.setCreateDate(new Date());
            post.setForumId(forumId);
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            post.setPostId(uuid);
            post.setPostName(postName);
            post.setReplyNum(0);
            post.setStatus(211);//2为非热帖
            post.setUserId(userId);
            post.setVisiteNum(0);
        } catch (Exception e){
            logger.error("param error of forumId:{}",forumId);
            return -1;
        }
        postDao.insert(post);
        return 0;
    }

    @Override
    public int replyPost(String userId,String postId,String floorText){
        Floor floor = new Floor();
        try{
            floor.setUserId(userId);
            floor.setStatus(0);
            floor.setTime(new Date());
            floor.setPostId(postId);
            floor.setFloorText(floorText);
            floor.setFloorGood(0);
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            floor.setFloorNum(floorDao.getMaxFloorNum(postId) + 1);
            floor.setFloorId(uuid);
        } catch (Exception e) {
            logger.error("param error of postId:{}",postId);
            return -1;
        }
        floorDao.insert(floor);
        return 0;
    }

    @Override
    public int changePost(String postId,String postName){
        Post post = postDao.selectByPrimaryKey(postId);
        if(post == null){
            logger.error("not found floorId:{}",postId);
            throw new ForumException(ForumResultCode.DB_STORE);
        }
        post.setPostName(postName);
        postDao.updateByPrimaryKey(post);
        return 0;
    }

    @Override
    public int deletePost(String postId){
        Post post = postDao.selectByPrimaryKey(postId);
        if(post == null){
            logger.error("not found floorId:{}",postId);
            throw new ForumException(ForumResultCode.DB_STORE);
        }
        int t = postDao.deleteByPrimaryKey(postId);
        if(t == 0){
            return -1;
        }
        return 0;
    }

    @Override
    public List<Post> queryPost(String userId)
    {
        List<Post> result;
        result = postDao.selectByUserId(userId);
        return result;
    }

    @Override
    public List<Post> queryPostByKeyword(String keyword)
    {
        StringBuffer buffer = new StringBuffer(keyword);
        buffer.insert(0, "%");              //关键字前后添加%号
        buffer.append("%");
        List<Post> result;
        result = postDao.selectByKeyword(buffer.toString());
        return result;
    }

    @Override
    public int modifyInfo(User user)
    {
        userDao.updateByPrimaryKey(user);
        return 0;
    }
}
