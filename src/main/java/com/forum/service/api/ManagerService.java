package com.forum.service.api;

import com.forum.entity.Post;

public interface ManagerService {
    /*
     **提权
     */
    void upLevel(String userId,int level);

    void deletePost(String postID);

    void updatePost(Post post);

    void setPostTop(String postId);

    void noSpeaking(String userId, int status);
}
