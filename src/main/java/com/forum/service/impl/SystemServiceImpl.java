package com.forum.service.impl;

import com.forum.dao.ForumMapper;
import com.forum.entity.Forum;
import com.forum.service.api.SystemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SystemServiceImpl implements SystemService {
    @Autowired
    ForumMapper forumDao;
    @Override
    public List<Forum> listForum(){
        List<Forum> list = new ArrayList<>();
        list = forumDao.selectAll();
        return list;
    }
}
