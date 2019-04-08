package com.zoe.shareDorm.vo;

import com.zoe.shareDorm.enums.HouseStateEnum;
import com.zoe.shareDorm.po.House;

import java.util.List;

public class HouseExcution {
    // 结果状态 为整数，如0
    private int state;

    // 状态标识 为字符串，说明state整数的业务意义。 如0表示在审核中
    private String stateInfo;

    // 房源数量
    private int count;

    // 操作的house(增删改房源的时候用到)
    private House house;

    // House列表(查询房源列表的时候使用)
    private List<House> houseList;

    public HouseExcution(){

    }

    // 房源操作失败的时候使用的构造器
    public HouseExcution(HouseStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // 房源操作成功的时候使用的构造器
    public HouseExcution(HouseStateEnum stateEnum,House house) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.house = house;
    }

    // 房源操作成功的时候使用的构造器
    public HouseExcution(HouseStateEnum stateEnum,List<House> houseList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.houseList = houseList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }


}
