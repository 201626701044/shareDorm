package com.zoe.shareDorm.mapper;

import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.vo.HouseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface HouseMapper {
    //列出所有房源
    public List<House> queryHouseList(HouseVo houseVo);

    /**
     * 插入房源
     */
    public int insertHouse(House house);
}
