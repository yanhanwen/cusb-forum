package com.forum.dao;

import com.forum.entity.Ip;

import java.util.List;

public interface IpMapper {
    int deleteByPrimaryKey(String ipId);

    int insert(Ip record);

    Ip selectByPrimaryKey(String floorId);

    List<Ip> selectAll();

    int updateByPrimaryKey(Ip record);

}