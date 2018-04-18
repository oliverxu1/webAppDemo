package com.mybatis.demo.dao;

import com.mybatis.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2, areaList.size());
    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        System.out.println(area.getAreaName());
        assertEquals("东苑", area.getAreaName());
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("店西");
        area.setPriority(15);
        int effectedNum = areaDao.insertArea(area);
        System.out.println(effectedNum);
        assertEquals(1, effectedNum);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaId(4);
        area.setPriority(18);
        area.setAreaName("花花");
        int effectedNum = areaDao.updateArea(area);
        System.out.println(effectedNum);
        assertEquals(1, effectedNum);
    }

    @Test
    public void deleteArea() {
        int effectedNum = areaDao.deleteArea(1);
        System.out.println(effectedNum);
        assertEquals(1, effectedNum);
    }
}