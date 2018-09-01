package com.forum.dao;

import com.forum.entity.History;
import java.util.List;

public interface HistoryMapper {
    int deleteByPrimaryKey(String ip);

    int insert(History record);

    History selectByPrimaryKey(String ip);

    List<History> selectAll();

    int updateByPrimaryKey(History record);
}