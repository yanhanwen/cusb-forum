package com.forum.service.impl;

import com.forum.ForumApplication;
import com.forum.dao.IpMapper;
import com.forum.dao.PostMapper;
import com.forum.dao.UserMapper;
import com.forum.entity.Ip;
import com.forum.entity.Post;
import com.forum.entity.User;
import com.forum.service.api.SystemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
@Transactional
public class CusbServiceImplTest
{
    @Autowired
    PostMapper postDao;

    @Autowired
    UserMapper userDao;

    @Autowired
    IpMapper ipDao;

    @Test
    public void queryPost()
    {
        List<Post> post = postDao.selectByUserId("1");
        System.out.println(post);
    }

    @Test
    public void queryPostByKeyword()
    {
    }

    @Test
    public void modifyInfo()
    {
    }

    @Test
    @Commit
    public void insert()
    {

        /*User user = new User();
        user.setUserId("2");
        user.setUserName("test_user");
        user.setUserPwd("123456");
        user.setSex(1);
        user.setAge(20);
        user.setUserAdd("test");
        user.setUserMail("test");
        user.setStatus(1);
        user.setPhone("13999999999");
        user.setLevel(1);
        userDao.insert(user);

        Post post = new Post();
        post.setPostId("2");
        post.setPostName("test_1");
        post.setCreateDate(new Timestamp(new Date().getTime()));
        post.setVisiteNum(0);
        post.setTopic("topic1");
        post.setReplyNum(1);
        post.setStatus(1);
        post.setForumId("1");
        post.setUserId("1");
        postDao.insert(post);
*/
        Ip ip=new Ip();
        ip.setIpId("1");
        ip.setIp("1243234124");
        ip.setTime(new Timestamp(new Date().getTime()));
        ip.setUserId("001");
        ipDao.insert(ip);
    }
}