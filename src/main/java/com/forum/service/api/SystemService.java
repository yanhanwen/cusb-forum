package com.forum.service.api;

import com.forum.entity.Floor;
import com.forum.entity.Forum;
import com.forum.entity.Ip;
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

<<<<<<< HEAD
    List<Ip> listIp();
=======
    /*
     **显示所有回帖
     */
    List<Floor> listFloor(String postId);
>>>>>>> 42bff8fd299e7c7a3df91b3d037669d3a8bf908b
}
