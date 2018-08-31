package com.forum.entity;

import java.sql.Timestamp;

public class Post {
    private String post_id;//帖子ID
    private String post_name;//帖子名称
    private Timestamp create_date;//发表日期
    private int visite_num;//访问总数
    private int reply_num;//回复总数
    private int status;//状态
    private String forum_id;
    private String user_id;

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public int getVisite_num() {
        return visite_num;
    }

    public void setVisite_num(int visite_num) {
        this.visite_num = visite_num;
    }

    public int getReply_num() {
        return reply_num;
    }

    public void setReply_num(int reply_num) {
        this.reply_num = reply_num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getForum_id() {
        return forum_id;
    }

    public void setForum_id(String forum_id) {
        this.forum_id = forum_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id='" + post_id + '\'' +
                ", post_name='" + post_name + '\'' +
                ", create_date=" + create_date +
                ", visite_num=" + visite_num +
                ", reply_num=" + reply_num +
                ", status=" + status +
                ", forum_id='" + forum_id + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
