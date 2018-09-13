package com.forum.dao;

import com.forum.entity.Floor;
import java.util.List;

public interface FloorMapper {
    int deleteByPrimaryKey(String floorId);

    int insert(Floor record);

    Floor selectByPrimaryKey(String floorId);

    List<Floor> selectAll();

    int updateByPrimaryKey(Floor record);

    int getMaxFloorNum(String postId);
}