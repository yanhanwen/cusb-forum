package com.forum.service.impl;

import com.forum.dao.FloorMapper;
import com.forum.dao.ForumMapper;
import com.forum.dao.IpMapper;
import com.forum.dao.PostMapper;
import com.forum.entity.Floor;
import com.forum.entity.Forum;
import com.forum.entity.Ip;
import com.forum.entity.Post;
import com.forum.service.api.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    ForumMapper forumDao;
    @Autowired
    PostMapper postDao;
    @Autowired
    IpMapper ipDao;
    @Autowired
    FloorMapper floorDao;

    @Override
    public List<Forum> listForum(){
        List<Forum> list = new ArrayList<>();
        list = forumDao.selectAll();
        return list;
    }

    @Override
    public List<Post> listPostOfTopic(String topic){
        List<Post> list = new ArrayList<>();
        list = postDao.selectByTopic(topic);
        return list;
    }

    @Override
    public List<Post> listPostOfForum(String forumId){
        List<Post> list = new ArrayList<>();
        list = postDao.selectByForum(forumId);
        return list;
    }

    @Override
    public List<Ip> listIp() {
        List<Ip> list = new ArrayList<>();
        list = ipDao.selectAll();
        return list;
    }

    @Override
    public List<Floor> listFloor(String postId){
        List<Floor> list = new ArrayList<>();
        list = floorDao.selectAll();
        return list;
    }
}
