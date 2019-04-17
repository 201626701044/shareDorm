package com.zoe.shareDorm.service;


import com.zoe.shareDorm.exceptions.HouseOperationExceptioin;
import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.vo.HouseExecution;
import com.zoe.shareDorm.vo.HouseVo;
import com.zoe.shareDorm.vo.ImageHolder;


import java.util.List;

public interface HouseService {
    //列出所有房源
    public List<House> queryHouseList(HouseVo houseVo);

    /**
     * 添加房源信息
     * @param house
     */
    public void insert(House house);

    /**
     * 添加商品信息及图片处理
     * @param house
     * @param thumbnail
     * @param houseImgList
     * @return
     * @throws HouseOperationExceptioin
     */
    HouseExecution addHouse(House house, ImageHolder thumbnail,
                            List<ImageHolder> houseImgList)
            throws HouseOperationExceptioin;
}
