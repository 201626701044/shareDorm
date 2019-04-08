package com.zoe.shareDorm.service.ipml;


import com.zoe.shareDorm.mapper.HouseMapper;
import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
   @Autowired
    HouseMapper houseMapper;

    @Override
    public List<House> queryHouseList() {
        return houseMapper.queryHouseList();
    }

    @Override
    public List<House> queryByArea(String area) {
        return houseMapper.queryByArea(area);
    }
}
