package com.forum.entity;

import java.io.Serializable;

public class Forum implements Serializable {
    private String forumId;

    private String forumName;

    private String forumText;

    private String fid;

    private static final long serialVersionUID = 1L;

    public String getForumId() {
        return forumId;
    }

    public void setForumId(String forumId) {
        this.forumId = forumId == null ? null : forumId.trim();
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName == null ? null : forumName.trim();
    }

    public String getForumText() {
        return forumText;
    }

    public void setForumText(String forumText) {
        this.forumText = forumText == null ? null : forumText.trim();
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", forumId=").append(forumId);
        sb.append(", forumName=").append(forumName);
        sb.append(", forumText=").append(forumText);
        sb.append(", fid=").append(fid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}