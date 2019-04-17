package com.zoe.shareDorm.service.ipml;


import com.sun.org.apache.bcel.internal.generic.IUSHR;
import com.zoe.shareDorm.enums.HouseStateEnum;
import com.zoe.shareDorm.exceptions.HouseOperationExceptioin;
import com.zoe.shareDorm.mapper.HouseImgMapper;
import com.zoe.shareDorm.mapper.HouseMapper;
import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.po.HouseImg;
import com.zoe.shareDorm.service.HouseService;
import com.zoe.shareDorm.util.ImageUtil;
import com.zoe.shareDorm.util.PathUtil;
import com.zoe.shareDorm.vo.HouseExecution;
import com.zoe.shareDorm.vo.HouseVo;
import com.zoe.shareDorm.vo.ImageHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
   @Autowired
    HouseMapper houseMapper;
   @Autowired
    HouseImgMapper houseImgMapper;

    @Override
    public List<House> queryHouseList(HouseVo houseVo) {
        return houseMapper.queryHouseList(houseVo);
    }


    @Override
    public void insert(House house) {
        houseMapper.insertHouse(house);
    }

    @Override
    @Transactional
    // 1.处理缩略图，获取缩略图相对路径并赋值给house
    // 2.往tb_house写入商品信息，获取houseId
    // 3.结合houseId批量处理商品详情图
    // 4.将商品详情图列表批量插入tb_house_img中
    public HouseExecution addHouse(House house, ImageHolder thumbnail, List<ImageHolder> houseImgHolderList)
            throws HouseOperationExceptioin {
        //空值判断
       if(house!=null){
           //给房源设置默认属性
           house.setCheckInDate(new Date());
           //默认为上架的状态
           house.setEnableStatus(1);
           if(thumbnail != null){
               addThumbnail(house,thumbnail);
           }
           try {
               //创建房源信息
               int effectedNum = houseMapper.insertHouse(house);
               if(effectedNum <= 0){
                   throw new HouseOperationExceptioin("创建房源失败");
               }
           }catch (Exception e){
               throw new HouseOperationExceptioin("创建房源失败:" + e.toString());
           }
           //若商品详情图片不为空则添加
           if(houseImgHolderList != null && houseImgHolderList.size() >0){
               addHouseImgList(house,houseImgHolderList);
           }
           return new HouseExecution(HouseStateEnum.SUCCESS, house);
       } else {
           //传参为空则返回空值错误信息
           return new HouseExecution(HouseStateEnum.EMPTY);
       }
    }

    /**
     * 批量添加图片
     *
     * @param house
     * @param houseImgHolderList
     */
    private void addHouseImgList(House house, List<ImageHolder> houseImgHolderList) {
        //获取图片存储路径，这里直接存放到相应房源的文件夹底下
        String dest = PathUtil.getHouseImagePath(house.getHouseId());
        List<HouseImg> houseImgList = new ArrayList<HouseImg>();
        //遍历图片一次处理，并添加进houseImg实体类里
        for (ImageHolder houseImgHolder : houseImgHolderList){
            String imgAddr = ImageUtil.generateNormalImg(houseImgHolder,dest);
            HouseImg houseImg = new HouseImg();
            houseImg.setImgAddr(imgAddr);
            houseImg.setHouseId(house.getHouseId());
            houseImg.setCreateTime(new Date());
            houseImgList.add(houseImg);
        }
        //如果确实有图片需要添加的，就执行批量添加操作
        if (houseImgList.size() > 0){
            try{
                int effectedNum = houseImgMapper.batchInsertHouseImg(houseImgList);
                if (effectedNum <= 0){
                    throw new HouseOperationExceptioin("创建商品详情图片失败");
                }
            }catch (Exception e){
                throw new HouseOperationExceptioin("创建商品详情图片失败:" + e.toString());
            }
        }


    }

    /**
     * 添加缩略图
     *
     * @param house
     * @param thumbnail
     */
    private void addThumbnail(House house, ImageHolder thumbnail) {
        String dest = PathUtil.getHouseImagePath(house.getHouseId());
        String thumbnailAddr = ImageUtil.generateThumbnail(thumbnail,dest);
        house.setImage(PathUtil.getHouseImagePathURL(thumbnailAddr));
    }
}
