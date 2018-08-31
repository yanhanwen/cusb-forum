package com.forum.dao;

import com.forum.entity.Post;

public interface PostMapper {
    Post selectByPostId(String post_id);

    int deleteByPostId(String post_id);

    int insert(Post record);

    int updateByPostId(String post_id);
}
