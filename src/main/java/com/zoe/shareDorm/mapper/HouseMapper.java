package com.zoe.shareDorm.mapper;

import com.zoe.shareDorm.po.House;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface HouseMapper {
    //列出所有房源
    public List<House> queryHouseList();

    List<House> queryByArea(@Param("area") String area);
}
