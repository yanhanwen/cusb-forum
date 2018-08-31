package com.forum.dao;

import com.forum.entity.Forum;

public interface ForumMapper {
    Forum selectByForumId(String forum_id);

    int deleteByForumId(String forum_id);

    int insert(Forum record);

    int updateByForumId(String forum_id);
}
