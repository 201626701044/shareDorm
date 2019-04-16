package com.zoe.shareDorm.service.ipml;


import com.zoe.shareDorm.mapper.HouseMapper;
import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.service.HouseService;
import com.zoe.shareDorm.vo.HouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
   @Autowired
    HouseMapper houseMapper;

    @Override
    public List<House> queryHouseList(HouseVo houseVo) {
        return houseMapper.queryHouseList(houseVo);
    }


    @Override
    public void insert(House house) {
        houseMapper.insert(house);
    }
}
