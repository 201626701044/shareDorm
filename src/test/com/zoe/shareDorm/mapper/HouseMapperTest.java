package com.zoe.shareDorm.mapper;

import com.zoe.shareDorm.po.House;

import com.zoe.shareDorm.util.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class HouseMapperTest extends BaseTest {

    @Autowired
    private HouseMapper houseMapper;

    @Test
    public void testQueryByArea(){

        String area = "新";
        List<House> house = houseMapper.queryByArea(area);
        System.out.println();

    }

    @Test
    public void testQueryHouseListAndCount(){

    }
}