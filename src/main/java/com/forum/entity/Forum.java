package com.forum.entity;

public class Forum {
    private String forum_id;//论坛ID
    private String forum_name;//论坛名称
    private String forum_text;//论坛描述
    private String fid;//父论坛ID

    public String getForum_id() {
        return forum_id;
    }

    public void setForum_id(String forum_id) {
        this.forum_id = forum_id == null ? null : forum_id.trim();
    }

    public String getForum_name() {
        return forum_name;
    }

    public void setForum_name(String forum_name) {
        this.forum_name = forum_name;
    }

    public String getForum_text() {
        return forum_text;
    }

    public void setForum_text(String forum_text) {
        this.forum_text = forum_text;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "forum_id='" + forum_id + '\'' +
                ", forum_name='" + forum_name + '\'' +
                ", forum_text='" + forum_text + '\'' +
                ", fid='" + fid + '\'' +
                '}';
    }
}
