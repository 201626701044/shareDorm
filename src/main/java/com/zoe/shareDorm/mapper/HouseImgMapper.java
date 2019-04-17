package com.zoe.shareDorm.mapper;

import com.zoe.shareDorm.po.HouseImg;

import java.util.List;

public interface HouseImgMapper {
    /**
     * 列出某个房源的详情图列表
     *
     * @param houseId
     * @return
     */

    List<HouseImg> queryHouseImgList(long houseId);

    /**
     * 批量添加房源详情图片
     *
     * @param houseImgList
     * @return
     */
    int batchInsertHouseImg(List<HouseImg> houseImgList);
}
