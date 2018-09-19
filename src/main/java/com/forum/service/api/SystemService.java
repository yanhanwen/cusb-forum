package com.forum.service.api;

import com.forum.entity.Forum;
import com.forum.entity.Post;

import java.util.List;

public interface SystemService {
    /*
     **分论坛显示
     */
    List<Forum> listForum();

    /*
     **主题显示
     */
    List<Post> listPostOfTopic(String topic);

    /*
     **显示帖子
     */
    List<Post> listPostOfForum(String forumId);
}
