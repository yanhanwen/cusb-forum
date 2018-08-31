package com.forum.dao;

import com.forum.entity.History;

public interface HistoryMapper {
    History selectByIp(String ip);

    int deleteByIp(String ip);

    int insert(History record);

    int updateByIp(String ip);
}
