/*
 Navicat MySQL Data Transfer

 Source Server         : localhost3306
 Source Server Type    : MySQL
 Source Server Version : 50561
 Source Host           : localhost:3306
 Source Schema         : sharedorm3.0

 Target Server Type    : MySQL
 Target Server Version : 50561
 File Encoding         : 65001

 Date: 02/04/2019 11:41:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_house
-- ----------------------------
DROP TABLE IF EXISTS `tb_house`;
CREATE TABLE `tb_house`  (
  `house_id` int(10) NOT NULL AUTO_INCREMENT,
  `house_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_id` int(20) NULL DEFAULT NULL,
  `rent_price` decimal(7, 2) NULL DEFAULT NULL,
  `check_in_date` datetime NULL DEFAULT NULL,
  `house_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rent_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `way` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`house_id`) USING BTREE,
  INDEX `FK_Reference_10`(`member_id`) USING BTREE,
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`member_id`) REFERENCES `tb_member` (`member_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_house
-- ----------------------------
INSERT INTO `tb_house` VALUES (1, '一号房', 1, 500.00, '2019-02-19 07:00:00', '3室2厅2卫', '新建区', '单人入住', 'img/house/01.jpg', '业主出租', '户型特点：户型方正，南北朝向，安静看花园', '男');
INSERT INTO `tb_house` VALUES (2, '二号房', 2, 700.00, '2019-12-10 10:00:00', '3室2厅独卫', '红谷滩', '双人入住', 'img/house/02.jpg', '室友合租', '高新中心地段，小区楼下就是在建设当中的广场，', '女');
INSERT INTO `tb_house` VALUES (3, '三号房', 3, 1000.00, '2019-12-09 12:00:00', '独卫', '西湖', '三人入住', 'img/house/03.jpg', '室友合租', '\r\n周边交通方便', '男');
INSERT INTO `tb_house` VALUES (4, '精装修', NULL, 1500.00, '2019-01-09 12:00:00', '3室2厅独卫', '青山湖', '单人入住', 'img/house/04.jpg', '业主出租', '周边交通方便', '女');
INSERT INTO `tb_house` VALUES (5, '胜利路', NULL, 2000.00, '2019-01-09 12:00:00', '独卫', '高新区', '三人入住', 'img/house/5b7e348892675.jpg', '室友合租', '周边交通方便', '男');
INSERT INTO `tb_house` VALUES (6, '步行街', NULL, 3000.00, '2019-12-09 12:00:00', '两室一厅', '南昌县', '单人入住', 'img/tb_house/5bacdc8b2f488.jpg', '业主出租', '高新中心地段，小区楼下就是在建设当中的广场，', '女');
INSERT INTO `tb_house` VALUES (7, '东京路', NULL, 1200.00, '2019-12-09 12:00:00', '3室2厅', '青云谱', '三人入住', 'img/tb_house/5bcc779b5c223.jpg', '室友合租', '高新中心地段，小区楼下就是在建设当中的广场，', '女');
INSERT INTO `tb_house` VALUES (8, '公寓', NULL, 800.00, '2019-12-09 12:00:00', '两室一厅独卫', '经开区', '单人入住', 'img/tb_house/5bcdcdcbb5a54.jpg', '业主出租', '高新中心地段，小区楼下就是在建设当中的广场，', '男');
INSERT INTO `tb_house` VALUES (9, '民宿', NULL, 2400.00, '2019-12-09 12:00:00', '3室2厅', '湾里', '四人入住', 'img/tb_house/05.jpg', '室友合租', '高新中心地段，小区楼下就是在建设当中的广场，', '男');
INSERT INTO `tb_house` VALUES (10, '中山路', NULL, 4500.00, '2019-12-09 12:00:00', '两室一厅', '进贤', '单人入住', 'img/house/06.jpg', '业主出租', '高新中心地段，小区楼下就是在建设当中的广场，', '男');

-- ----------------------------
-- Table structure for tb_member
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member`  (
  `member_id` int(20) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `member_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_image` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_id_card` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_member
-- ----------------------------
INSERT INTO `tb_member` VALUES (1, 'zoeaa', '1234', '3e41e9fd-38dc-469d-a148-82b25aaa3ccd1521949392720-2.PNG', '男', '11111111111', '18296646142', '1259992619@qq.com');
INSERT INTO `tb_member` VALUES (2, 'root', 'root', NULL, '男', '33333333333', '13979635082', '701044@qq.com');
INSERT INTO `tb_member` VALUES (3, 'admin', 'admin', NULL, '女', '22222222222', '13767612783', 'zoe@jxnu.edu.cn');
INSERT INTO `tb_member` VALUES (4, 'xiaoxiao', 'xiaoxiao', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (6, '小易', '1234', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (8, '12345', '11111', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (9, 'zoe11', 'zoe11', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (10, 'ssss', '1111', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (11, 'zoe?', '1234', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (13, '12345', NULL, 'ebdacfbc-9c87-4415-b5f2-97551e34778a1521949392720-2.PNG', NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (15, 'xkaaaaaaa', NULL, 'd3cb0dfd-597e-4194-8b52-cc40f9f3a4c0b1.jpg', NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (16, 'bbbbbbb', NULL, '1b6f6179-e952-406e-9bed-ed6a3fd898f71521949392720-2.PNG', NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (17, '', NULL, '4769d620-daae-4647-9166-68c319f33d8c1521949392720-2.PNG', NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (18, 'aaaaaa', NULL, '58df32ef-a754-41b9-8802-e45febcf4805', NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (19, 'aaa', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (21, '', NULL, 'ec486588-4583-4fef-8a68-f132988edd1ab1.jpg', NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (22, '', NULL, 'fecbb633-9e3c-4e71-b4b3-6ac5dfeda18bavatar-default-3.png', NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (23, 'aaasa5820asd', 'ryryryt', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (24, 'jerry', 'ryryryt', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (25, 'zoe', '123456', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (26, '啊啊', NULL, 'aa1952d2-cfee-4e95-8053-d0a73008f6fetimg13JVUNH6.jpg', NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (27, '安安', NULL, '14ab2f6e-fc06-4f05-af65-3fef54eea20btimg13JVUNH6.jpg', NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (28, '等等', NULL, '6e99e181-ce5a-4f47-8db6-4a2a719c3ec7timg13JVUNH6.jpg', NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (29, '阿萨', NULL, '7143a180-0276-4619-b779-cecbe6483525timg13JVUNH6.jpg', NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (30, '安安', NULL, 'bff19cf1-0198-4888-994c-f9875a9b2c29timg13JVUNH6.jpg', NULL, NULL, NULL, NULL);
INSERT INTO `tb_member` VALUES (31, '刚刚好', NULL, 'cd01c1cf-4f35-43c3-a5ac-9f90b0938316timg13JVUNH6.jpg', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tb_request
-- ----------------------------
DROP TABLE IF EXISTS `tb_request`;
CREATE TABLE `tb_request`  (
  `req_id` int(20) NOT NULL AUTO_INCREMENT,
  `req_time` datetime NULL DEFAULT NULL,
  `member_id` int(20) NULL DEFAULT NULL,
  `house_id` int(10) NULL DEFAULT NULL,
  `budget` decimal(10, 0) NULL DEFAULT NULL,
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mate_sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mate_character` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`req_id`) USING BTREE,
  INDEX `FK_Reference_7`(`member_id`) USING BTREE,
  INDEX `FK_Reference_8`(`house_id`) USING BTREE,
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`member_id`) REFERENCES `tb_member` (`member_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`house_id`) REFERENCES `tb_house` (`house_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_request
-- ----------------------------
INSERT INTO `tb_request` VALUES (1, '2018-11-15 14:18:15', 1, 1, 2500, '南昌', '男', '天间一袭袍', '软件工程师', 'img/avatar/avatar-default-3.png', '要求室友安静，会编程者优先');
INSERT INTO `tb_request` VALUES (2, '2018-11-15 11:18:15', 2, 2, 2000, '抚州', '女', '谓语动词', '老师', 'img\\avatar\\avatar-default-1.png', '喜欢干净');
INSERT INTO `tb_request` VALUES (3, '2018-12-05 14:18:15', NULL, 3, 2000, '丰城', '女', '空白', '白领', 'img/avatar/1521949392720-2.PNG', '希望室友是女性，');

SET FOREIGN_KEY_CHECKS = 1;
