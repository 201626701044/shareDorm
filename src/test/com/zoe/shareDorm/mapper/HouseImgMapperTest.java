package com.zoe.shareDorm.mapper;

import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.po.HouseImg;
import com.zoe.shareDorm.util.BaseTest;
import com.zoe.shareDorm.vo.HouseVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class HouseImgMapperTest extends BaseTest {

    @Autowired
    private HouseImgMapper houseImgMapper;

    @Test
    public void testBatchInsertHouseImg() throws Exception{
        //houseId为1的商品里添加两个详情图片记录
        HouseImg houseImg = new HouseImg();
        houseImg.setImgAddr("图片");
        houseImg.setCreateTime(new Date());
        houseImg.setHouseId(1);
        HouseImg houseImg1 = new HouseImg();
        houseImg1.setImgAddr("图片1");
        houseImg1.setCreateTime(new Date());
        houseImg1.setHouseId(1);
        List<HouseImg> houseImgList = new ArrayList<HouseImg>();
        houseImgList.add(houseImg);
        houseImgList.add(houseImg1);
        int effectedNum = houseImgMapper.batchInsertHouseImg(houseImgList);
        assertEquals(2,effectedNum);
    }

}