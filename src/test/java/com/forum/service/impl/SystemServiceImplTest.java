package com.forum.service.impl;

import com.forum.ForumApplication;
import com.forum.service.api.SystemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
@Transactional
public class SystemServiceImplTest {
    @Autowired
    SystemService systemService;

    @Test
    public void listForum() {
        System.out.println(systemService.listForum());
    }
}