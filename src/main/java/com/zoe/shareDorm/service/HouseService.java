package com.zoe.shareDorm.service;


import com.zoe.shareDorm.po.House;


import java.util.List;

public interface HouseService {
    //列出所有房源
    public List<House> queryHouseList();

    List<House> queryByArea(String area);
}
