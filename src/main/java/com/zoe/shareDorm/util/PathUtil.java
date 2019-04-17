package com.zoe.shareDorm.util;

public class PathUtil {
    private static String seperator = System.getProperty("file.separator");
    //返回项目图片的根路径
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/projectdev/image";
        } else {
            //linux
            basePath = "/Users/baidu/work/image";
        }
        //将/替换成系统对应的分隔符
        basePath = basePath.replace("/", seperator);
        return basePath;
    }
    //依据不同的业务需求，返回项目图片子路径。如将图片分别存储在各自的店面下
    public static String getHouseImagePath(Integer houseId){
        String imagePath = "/upload/images/item/house/" + houseId + "/";
        return imagePath.replace("/",seperator);
    }
    //依据不同的业务需求，返回项目图片子路径。如将图片分别存储在各自的店面下
    public static String getHouseImagePathURL(String imagePath) {

        return imagePath.replace(seperator,"/");
    }


    public static void main(String arg[]){

        String imgpath=PathUtil.getHouseImagePath(1);
        System.out.println(PathUtil.getHouseImagePathURL(imgpath));
    }

}
