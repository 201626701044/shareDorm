package com.zoe.shareDorm.mapper;

import com.zoe.shareDorm.po.House;

import com.zoe.shareDorm.util.BaseTest;
import com.zoe.shareDorm.vo.HouseVo;
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
    public void testQueryList(){

        HouseVo houseVo=new HouseVo();
        houseVo.setArea("青山湖");
        houseVo.setNum("单人入住");
        List<House> house = houseMapper.queryHouseList(houseVo);
        System.out.println(house.size());

    }

    @Test
    public void testQueryHouseListAndCount(){

    }
}