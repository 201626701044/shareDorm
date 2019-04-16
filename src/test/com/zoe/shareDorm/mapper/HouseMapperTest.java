package com.zoe.shareDorm.mapper;

import com.zoe.shareDorm.po.House;

import com.zoe.shareDorm.util.BaseTest;
import com.zoe.shareDorm.vo.HouseVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class HouseMapperTest extends BaseTest {

    @Autowired
    private HouseMapper houseMapper;



    @Test
    public void testQueryList(){

        HouseVo houseVo=new HouseVo();
        houseVo.setArea("青山湖");
//        houseVo.setNum("单人入住");
        List<House> house = houseMapper.queryHouseList(houseVo);
        System.out.println(house.size());

    }

    @Test
    public void testInsertHouse() throws Exception{
        House house = new House();
        house.setHouseName("测试2");
        house.setRentPrice((float) 700);
        house.setHouseType("单间独卫");
        house.setArea("西湖");
        house.setImage("/img/house/01.jpg");
        house.setWay("业主出租");

        int effectedNum = houseMapper.insert(house);
        assertEquals(1,effectedNum);


    }
}