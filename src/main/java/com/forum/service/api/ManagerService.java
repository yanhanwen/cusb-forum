package com.forum.service.api;


import com.forum.entity.Post;
import com.forum.entity.Forum;

public interface ManagerService {
    /*
     **提权
     */
    void upLevel(String userId,int level);

    void deletePost(String postID);

    void updatePost(Post post);

    void setPostTop(String postId);

    void noSpeaking(String userId, int status);

    /*管理员增加分论坛*/
    void adminAddForum(Forum forum);

    /*管理员删除分论坛*/
    void adminDeleteForum(String forumId);

    /*管理员修改分论坛*/
    void adminChangeForum(Forum forum);

    /*管理员查询分论坛*/
    Forum adminSearchForum(String forumName);

}
