package com.zoe.shareDorm.service.ipml;


import com.zoe.shareDorm.exceptions.HouseOperationExceptioin;
import com.zoe.shareDorm.mapper.AreaMapper;
import com.zoe.shareDorm.po.Area;
import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.service.AreaService;
import com.zoe.shareDorm.service.HouseService;
import com.zoe.shareDorm.vo.HouseExcution;
import com.zoe.shareDorm.vo.ImageHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AreaServiceImpl")
public class AreaServiceImpl implements AreaService {

   @Autowired
   @Qualifier("AreaMapper")
   private AreaMapper areaMapper;

    @Override
    public List<Area> getAreaList() {
        return areaMapper.queryArea();
    }


}
