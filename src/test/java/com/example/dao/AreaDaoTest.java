package com.example.dao;

import com.example.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.transform.Source;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xnz
 * @date 2019/9/19 19:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areas = areaDao.queryArea();
        System.out.println(areas);
    }
}