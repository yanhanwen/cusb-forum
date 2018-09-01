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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
@Transactional
public class FloorMapperTest {

    @Autowired
    FloorMapper dao;

    @Test
    public void selectByFloorId() {
        Floor f = dao.selectByPrimaryKey("1");
        Assert.assertNull(f);
    }

    @Test
    @Rollback
    public void deleteByFloorId() {
        int t = dao.deleteByPrimaryKey("1");
        Assert.assertEquals(t,0);
    }

    @Test
    @Rollback
    public void insert() {
    }

    @Test
    @Rollback
    public void updateByFloorId() {
    }
}