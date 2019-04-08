package com.zoe.shareDorm.enums;

public enum HouseStateEnum {
    CHECK(0, "审核中"), OFFLINE(-1, "非法店铺"), SUCCESS(1, "操作成功"), PASS(2, "通过认证"), INNER_ERROR(-1001,
            "内部系统错误"), NULL_HOUSEID(-1002, "HouseId为空"),NULL_HOUSE(-1003, "house信息为空");
    private int state;
    private String stateInfo;
    //不希望外部可以修改房源的状态类型
    //构造器
    HouseStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
    /**
     * 依据传入的state返回相应的enum值
     */
    public static HouseStateEnum stateOf(int state){
        for(HouseStateEnum stateEnum : values()){
            if (stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }

}
