package com.forum.dao;

import com.forum.ForumApplication;
import com.forum.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
@Transactional
public class ForumMapperTest {
    @Autowired
    ForumMapper forumDao;

    @Test
    @Commit
    public void insert() {
        Forum record = new Forum();
        record.setFid("12");
        record.setForumId("123");
        record.setForumName("测试论坛");
        record.setForumText("666");
        forumDao.insert(record);
    }
}