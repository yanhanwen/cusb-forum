package com.forum.dao;

import com.forum.entity.Forum;
import java.util.List;

public interface ForumMapper {
    int deleteByPrimaryKey(String forumId);

    int insert(Forum record);

    Forum selectByPrimaryKey(String forumId);

    List<Forum> selectAll();

    int updateByPrimaryKey(Forum record);
}
