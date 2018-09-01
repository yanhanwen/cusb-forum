package com.forum.entity;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {
    private String replyId;

    private Date time;

    private String replyText;

    private Integer replyGoot;

    private Integer status;

    private String floorId;

    private String userId;

    private String userIdReplied;

    private static final long serialVersionUID = 1L;

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId == null ? null : replyId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText == null ? null : replyText.trim();
    }

    public Integer getReplyGoot() {
        return replyGoot;
    }

    public void setReplyGoot(Integer replyGoot) {
        this.replyGoot = replyGoot;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId == null ? null : floorId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserIdReplied() {
        return userIdReplied;
    }

    public void setUserIdReplied(String userIdReplied) {
        this.userIdReplied = userIdReplied == null ? null : userIdReplied.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", replyId=").append(replyId);
        sb.append(", time=").append(time);
        sb.append(", replyText=").append(replyText);
        sb.append(", replyGoot=").append(replyGoot);
        sb.append(", status=").append(status);
        sb.append(", floorId=").append(floorId);
        sb.append(", userId=").append(userId);
        sb.append(", userIdReplied=").append(userIdReplied);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}