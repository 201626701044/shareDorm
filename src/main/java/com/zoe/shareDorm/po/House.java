package com.zoe.shareDorm.po;

import java.util.Date;
import java.util.List;
/**
 * 房源实体类
 *
 * @author
 *
 */
public class House {

    // 主键ID
    private Integer houseId;
    //房源名
    private String houseName;
    //房东ID
    private Integer memberId;
    //出租价格
    private Float rentPrice;
    //入住时间
    private Date checkInDate;
    //房源类型
    private String houseType;
    //地区
    private String area;
    //求租人数
    private String rentNum;
    //图片
    private String image;
    //求租方式
    private String way;
    //详情描述
    private String description;
    //性别
    private String sex;

    // 0.下架 1.在前端展示系统展示
    private Integer enableStatus;

    //房子是属于哪个人的
    private Member member;
    // 图片详情图列表，跟商品是多对一的关系
    private List<HouseImg> houseImgList;

    /**
     * 非数据库字段
     * 一个房源对应多个请求
     */
    private List<Request> requests;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Float rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRentNum() {
        return rentNum;
    }

    public void setRentNum(String rentNum) {
        this.rentNum = rentNum;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<HouseImg> getHouseImgList() {
        return houseImgList;
    }

    public void setHouseImgList(List<HouseImg> houseImgList) {
        this.houseImgList = houseImgList;
    }
}
