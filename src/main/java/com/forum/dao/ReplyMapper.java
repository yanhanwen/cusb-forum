package com.forum.dao;

import com.forum.entity.Reply;
import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(String replyId);

    int insert(Reply record);

    Reply selectByPrimaryKey(String replyId);

    List<Reply> selectAll();

    int updateByPrimaryKey(Reply record);
}