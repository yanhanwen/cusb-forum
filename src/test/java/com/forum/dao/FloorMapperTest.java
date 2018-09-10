package com.forum.dao;

import com.forum.ForumApplication;
import com.forum.entity.Floor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
@Transactional
public class FloorMapperTest {

    @Autowired
    FloorMapper dao;

    @Test
    public void selectByFloorId() {
        Floor f = dao.selectByPrimaryKey("1");
        Assert.assertNotNull(f);
    }

    @Test
    @Rollback
    public void deleteByFloorId() {
        int t = dao.deleteByPrimaryKey("1");
        Assert.assertEquals(t,1
        );
    }

    @Test
//    @Rollback
    public void insert() {
        Floor f = new Floor();
        f.setFloorId("1");
        f.setFloorGood(10);
        f.setFloorNum(1);
        f.setFloorText("hello");
        f.setPostId("");
        f.setTime(new Date());
        f.setStatus(1);
        f.setUserId("");
    }

    @Test
    @Rollback
    public void updateByFloorId() {
    }
}