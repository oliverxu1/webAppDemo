package com.mybatis.demo.dao;

import com.mybatis.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    List<Area> queryArea();

    Area queryAreaById(int areaId);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteArea(int areaId);
}
