package com.forum.dao;

import com.forum.entity.Post;
import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(String postId);

    int insert(Post record);

    Post selectByPrimaryKey(String postId);

    List<Post> selectAll();

    int updateByPrimaryKey(Post record);

    List<Post> selectByUserId(String userId);

    List<Post> selectByKeyword(String keyword);

    List<Post> selectByTopic(String topic);

    List<Post> selectByForum(String forumId);
}