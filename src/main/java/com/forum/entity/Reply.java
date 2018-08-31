package com.forum.entity;

import java.sql.Timestamp;

public class Reply {
    private String reply_id;//回复唯一标识
    private Timestamp time;//时间
    private String reply_text;//内容
    private int reply_goot;//赞数
    private int status;//状态
    private String floor_id;
    private String user_id;
    private String user_id_replieduser;

    public String getReply_id() {
        return reply_id;
    }

    public void setReply_id(String reply_id) {
        this.reply_id = reply_id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getReply_text() {
        return reply_text;
    }

    public void setReply_text(String reply_text) {
        this.reply_text = reply_text;
    }

    public int getReply_goot() {
        return reply_goot;
    }

    public void setReply_goot(int reply_goot) {
        this.reply_goot = reply_goot;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(String floor_id) {
        this.floor_id = floor_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id_replieduser() {
        return user_id_replieduser;
    }

    public void setUser_id_replieduser(String user_id_replieduser) {
        this.user_id_replieduser = user_id_replieduser;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "reply_id='" + reply_id + '\'' +
                ", time=" + time +
                ", reply_text='" + reply_text + '\'' +
                ", reply_goot=" + reply_goot +
                ", status=" + status +
                ", floor_id='" + floor_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_id_replieduser='" + user_id_replieduser + '\'' +
                '}';
    }
}
