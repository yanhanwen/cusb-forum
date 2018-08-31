package com.forum.dao;

import com.forum.entity.Floor;

public interface FloorMapper {
    Floor selectByFloorId(String floor_id);

    int deleteByFloorId(String floor_id);

    int insert(Floor record);

    int updateByFloorId(String floor_id);
}
