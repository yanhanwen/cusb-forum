package com.forum.entity;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {
    private String postId;

    private String postName;

    private Date createDate;

    private Integer visiteNum;

    private Integer replyNum;

    private String topic;

    private Integer status;

    private String forumId;

    private String userId;

    private static final long serialVersionUID = 1L;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getVisiteNum() {
        return visiteNum;
    }

    public void setVisiteNum(Integer visiteNum) {
        this.visiteNum = visiteNum;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getForumId() {
        return forumId;
    }

    public void setForumId(String forumId) {
        this.forumId = forumId == null ? null : forumId.trim();
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
        sb.append(", postId=").append(postId);
        sb.append(", postName=").append(postName);
        sb.append(", createDate=").append(createDate);
        sb.append(", visiteNum=").append(visiteNum);
        sb.append(", replyNum=").append(replyNum);
        sb.append(", topic=").append(topic);
        sb.append(", status=").append(status);
        sb.append(", forumId=").append(forumId);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}