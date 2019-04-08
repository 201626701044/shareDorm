package com.zoe.shareDorm.service;

import com.zoe.shareDorm.exceptions.HouseOperationExceptioin;
import com.zoe.shareDorm.po.Area;
import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.vo.HouseExcution;
import com.zoe.shareDorm.vo.ImageHolder;

import java.util.List;

public interface AreaService {

    List<Area> getAreaList();
}
