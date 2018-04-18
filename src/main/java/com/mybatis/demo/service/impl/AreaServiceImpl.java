package com.mybatis.demo.service.impl;

import com.mybatis.demo.dao.AreaDao;
import com.mybatis.demo.entity.Area;
import com.mybatis.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("信息不能为空！");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("Id不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("Id不能为空！");
        }
    }
}
