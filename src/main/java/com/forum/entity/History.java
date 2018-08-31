package com.forum.entity;

import java.sql.Timestamp;

public class History {
    private String ip;//访问IP
    private Timestamp time;//时间戳
    private String user_id;//用户ID外键

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "History{" +
                "ip='" + ip + '\'' +
                ", time=" + time +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
