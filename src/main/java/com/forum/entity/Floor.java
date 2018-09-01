package com.forum.entity;

import java.io.Serializable;
import java.util.Date;

public class Floor implements Serializable {
    private String floorId;

    private Integer floorNum;

    private Integer floorGood;

    private String floorText;

    private Integer status;

    private Date time;

    private String postId;

    private String userId;

    private static final long serialVersionUID = 1L;

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId == null ? null : floorId.trim();
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    public Integer getFloorGood() {
        return floorGood;
    }

    public void setFloorGood(Integer floorGood) {
        this.floorGood = floorGood;
    }

    public String getFloorText() {
        return floorText;
    }

    public void setFloorText(String floorText) {
        this.floorText = floorText == null ? null : floorText.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", floorId=").append(floorId);
        sb.append(", floorNum=").append(floorNum);
        sb.append(", floorGood=").append(floorGood);
        sb.append(", floorText=").append(floorText);
        sb.append(", status=").append(status);
        sb.append(", time=").append(time);
        sb.append(", postId=").append(postId);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}