package com.zoe.shareDorm.service;


import com.zoe.shareDorm.enums.HouseStateEnum;
import com.zoe.shareDorm.exceptions.HouseOperationExceptioin;
import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.util.BaseTest;
import com.zoe.shareDorm.vo.HouseExecution;
import com.zoe.shareDorm.vo.ImageHolder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HouseServiceTest extends BaseTest {

    @Autowired
    private HouseService houseService;

    @Test
    public void testAddHouse() throws HouseOperationExceptioin, FileNotFoundException {
        //创建houseId为1的商品实例并给其成员变量赋值
        House house = new House();
        house.setHouseName("测试房源1");
        house.setRentPrice((float) 700);
        house.setCheckInDate(new Date());
        house.setHouseType("三室两厅");
        house.setEnableStatus(HouseStateEnum.SUCCESS.getState());
        //创建缩略图文件流
        File thumbnailFile = new File("d:/img/a.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(),is);
        //创建两个房源详情图片文件流并将他们添加到详情图列表中
        File houseImg1 = new File("d:/img/a.jpg");
        InputStream is1 = new FileInputStream(houseImg1);
        File houseImg2 = new File("d:/img/newa.jpg");
        InputStream is2 = new FileInputStream(houseImg2);
        List<ImageHolder> houseImgList = new ArrayList<ImageHolder>();
        houseImgList.add(new ImageHolder(houseImg1.getName(),is1));
        houseImgList.add(new ImageHolder(houseImg2.getName(),is2));
        //添加房源并验证
        HouseExecution pe = houseService.addHouse(house,thumbnail,houseImgList);
        assertEquals(HouseStateEnum.SUCCESS.getState(),pe.getState());
    }

}
