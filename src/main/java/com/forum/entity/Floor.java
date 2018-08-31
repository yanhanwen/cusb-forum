package com.forum.entity;

import java.sql.Timestamp;

public class Floor {
    private String floor_id;//楼层标识
    private int floor_num;//楼层数
    private int floor_good;//楼层赞数
    private String floor_text;//楼层内容
    private int status;//楼层状态
    private Timestamp time;//时间
    private String post_id;
    private String user_id;

    public String getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(String floor_id) {
        this.floor_id = floor_id == null ? null : floor_id.trim();
    }

    public int getFloor_num() {
        return floor_num;
    }

    public void setFloor_num(int floor_num) {
        this.floor_num = floor_num;
    }

    public int getFloor_good() {
        return floor_good;
    }

    public void setFloor_good(int floor_good) {
        this.floor_good = floor_good;
    }

    public String getFloor_text() {
        return floor_text;
    }

    public void setFloor_text(String floor_text) {
        this.floor_text = floor_text;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floor_id='" + floor_id + '\'' +
                ", floor_num=" + floor_num +
                ", floor_good=" + floor_good +
                ", floor_text='" + floor_text + '\'' +
                ", status=" + status +
                ", time=" + time +
                ", post_id='" + post_id + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
