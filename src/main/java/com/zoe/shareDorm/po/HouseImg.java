package com.zoe.shareDorm.po;

import java.util.Date;

/**
 * 房源详情图实体类
 *
 */
public class HouseImg {
    // 主键ID
    private Long houseImgId;
    // 图片地址
    private String imgAddr;
    // 创建时间
    private Date createTime;
    // 标明是属于哪个房源的图片
    private Integer houseId;

    public Long getHouseImgId() {
        return houseImgId;
    }

    public void setHouseImgId(Long houseImgId) {
        this.houseImgId = houseImgId;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
