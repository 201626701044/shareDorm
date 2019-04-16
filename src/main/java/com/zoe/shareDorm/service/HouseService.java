package com.zoe.shareDorm.service;


import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.vo.HouseVo;


import java.util.List;

public interface HouseService {
    //列出所有房源
    public List<House> queryHouseList(HouseVo houseVo);

    /**
     * 添加房源信息
     * @param house
     */
    public void insert(House house);
}
