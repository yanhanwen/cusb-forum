package com.forum.dao;

import com.forum.entity.Reply;

public interface ReplyMapper {
    Reply selectByReplyId(String reply_id);

    int deleteByReplyId(String reply_id);

    int insert(Reply record);

    int updateByReplyId(String reply_id);
}
