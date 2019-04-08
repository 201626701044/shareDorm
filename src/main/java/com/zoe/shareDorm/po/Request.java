package com.zoe.shareDorm.po;

public class Request {
    private Integer reqId;
    private Integer memberId;
    private Integer houseId;
    private String reqTime;
    private float budget;
    private String city;
    private String mateSex;
    private String nickName;
    private String job;
    private String image;
    private String mateCharacter;

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMateSex() {
        return mateSex;
    }

    public void setMateSex(String mateSex) {
        this.mateSex = mateSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMateCharacter() {
        return mateCharacter;
    }

    public void setMateCharacter(String mateCharacter) {
        this.mateCharacter = mateCharacter;
    }
}
