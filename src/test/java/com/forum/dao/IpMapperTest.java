package com.forum.dao;

import com.forum.ForumApplication;
import com.forum.entity.Ip;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
@Transactional
public class IpMapperTest {

    @Autowired
    IpMapper dao;

    @Test
    public void selectByFloorId() {
        Ip f = dao.selectByPrimaryKey("1");
        Assert.assertNotNull(f);
    }

    @Test
    @Rollback
    public void deleteByFloorId() {
        int t = dao.deleteByPrimaryKey("1");
        Assert.assertEquals(t,1);
    }

    @Test
//    @Rollback
    @Commit
    public void insert() {
        Ip f = new Ip();
        f.setIpId("1");
        f.setUserId("001");
        f.setIp("191.168.49.140");
        f.setTime(new Timestamp(new Date().getTime()));
        dao.insert(f);
    }

    @Test
    @Rollback
    public void updateByFloorId() {
    }

    @Test
    public void uuidTest(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
    }
}