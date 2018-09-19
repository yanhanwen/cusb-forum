package com.forum.service.impl;

import com.forum.common.ForumException;
import com.forum.common.ForumResultCode;
import com.forum.dao.UserMapper;
import com.forum.entity.Post;
import com.forum.entity.User;
import com.forum.service.api.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.forum.dao.PostMapper;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    UserMapper userDao;
    @Autowired
    PostMapper postDao;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void upLevel(String userId, int level) {
        User user = userDao.selectByPrimaryKey(userId);
        if (user == null) {
            logger.error("not found userId:{}", userId);
            throw new ForumException(ForumResultCode.DB_STORE);
        }
        user.setLevel(level);
        userDao.updateByPrimaryKey(user);
    }

    public void deletePost(String postId)
    {
        int ret;
        ret = postDao.deleteByPrimaryKey(postId);
        if (ret != 1)
        {
            logger.error("delete postId:{} error",postId);
            throw new ForumException((ForumResultCode.DB_STORE));
        }

    }

    public void updatePost(Post post)
    {
        int ret;
        ret = postDao.updateByPrimaryKey(post);
        if (ret != 1)
        {
            logger.error("update postId:{} error",post.getPostId());
            throw new ForumException((ForumResultCode.DB_STORE));
        }
    }

    public  void setPostTop(String postId)
    {
        Post post = postDao.selectByPrimaryKey(postId);
        int ret;

        int s = post.getStatus();
        s = s / 10;
        s = s % 10;
        if ((s / 10) % 10  == 1)
            post.setStatus(s + 10);
        else
            post.setStatus(s - 10);
        ret = postDao.updateByPrimaryKey(post);
        if (ret != 1)
        {
            logger.error("update postId:{} error",post.getPostId());
            throw new ForumException((ForumResultCode.DB_STORE));
        }

    }

    public void noSpeaking (String userId, int status)
    {
        //2为禁言，3为能发言
        User user = userDao.selectByPrimaryKey(userId);
        if (user == null) {
            logger.error("not found userId:{}", userId);
            throw new ForumException(ForumResultCode.DB_STORE);
        }
        int s;
        s = user.getStatus();
        s = s / 10 + status;
        user.setStatus(s);
        userDao.updateByPrimaryKey(user);

    }
}
