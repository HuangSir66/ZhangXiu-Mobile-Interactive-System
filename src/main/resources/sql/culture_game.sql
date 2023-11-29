/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80034
Source Host           : localhost:3306
Source Database       : culture_game

Target Server Type    : MYSQL
Target Server Version : 80034
File Encoding         : 65001

Date: 2023-11-29 10:13:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_accessory`
-- ----------------------------
DROP TABLE IF EXISTS `sys_accessory`;
CREATE TABLE `sys_accessory` (
  `id` bigint NOT NULL COMMENT '主键\r\n',
  `accessory` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '配饰路径',
  `accessory_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '配饰名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_accessory
-- ----------------------------
INSERT INTO `sys_accessory` VALUES ('1', '士大夫是', '阿斯顿发生');

-- ----------------------------
-- Table structure for `sys_color`
-- ----------------------------
DROP TABLE IF EXISTS `sys_color`;
CREATE TABLE `sys_color` (
  `id` bigint NOT NULL,
  `color` varchar(50) NOT NULL COMMENT '色彩类别',
  `color_url` varchar(50) NOT NULL COMMENT '色彩图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_color
-- ----------------------------
INSERT INTO `sys_color` VALUES ('1', '红色', '123123');
INSERT INTO `sys_color` VALUES ('2', '绿色', '12313213');
INSERT INTO `sys_color` VALUES ('3', '蓝色', '12321312');
INSERT INTO `sys_color` VALUES ('4', '粉色', '1232131');

-- ----------------------------
-- Table structure for `sys_color_count`
-- ----------------------------
DROP TABLE IF EXISTS `sys_color_count`;
CREATE TABLE `sys_color_count` (
  `id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `color` varchar(50) NOT NULL,
  `count` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `color_user_id` (`user_id`),
  CONSTRAINT `color_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_color_count
-- ----------------------------
INSERT INTO `sys_color_count` VALUES ('1', '1728697951154348033', '红色', '0');
INSERT INTO `sys_color_count` VALUES ('1728980602813730817', '1728978849233956865', '红色', '0');
INSERT INTO `sys_color_count` VALUES ('1728980602813730818', '1728978849233956865', '绿色', '0');
INSERT INTO `sys_color_count` VALUES ('1728980602838896642', '1728978849233956865', '蓝色', '0');
INSERT INTO `sys_color_count` VALUES ('1728980602838896643', '1728978849233956865', '粉色', '0');
INSERT INTO `sys_color_count` VALUES ('1728980862638239750', '1728980862336249857', '红色', '0');
INSERT INTO `sys_color_count` VALUES ('1728980862638239751', '1728980862336249857', '绿色', '0');
INSERT INTO `sys_color_count` VALUES ('1728980862638239752', '1728980862336249857', '蓝色', '0');
INSERT INTO `sys_color_count` VALUES ('1728980862638239753', '1728980862336249857', '粉色', '0');
INSERT INTO `sys_color_count` VALUES ('1729372517920940038', '1729372517585395713', '红色', '0');
INSERT INTO `sys_color_count` VALUES ('1729372517979660289', '1729372517585395713', '绿色', '0');
INSERT INTO `sys_color_count` VALUES ('1729372517979660290', '1729372517585395713', '蓝色', '0');
INSERT INTO `sys_color_count` VALUES ('1729372517979660291', '1729372517585395713', '粉色', '0');

-- ----------------------------
-- Table structure for `sys_costume`
-- ----------------------------
DROP TABLE IF EXISTS `sys_costume`;
CREATE TABLE `sys_costume` (
  `id` bigint NOT NULL COMMENT '主键\r\n',
  `costume` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服饰路径',
  `costume_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服饰名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_costume
-- ----------------------------
INSERT INTO `sys_costume` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `sys_embroidery_method`
-- ----------------------------
DROP TABLE IF EXISTS `sys_embroidery_method`;
CREATE TABLE `sys_embroidery_method` (
  `id` bigint NOT NULL COMMENT '主键',
  `method` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '针绣形状路径',
  `method_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '针绣名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_embroidery_method
-- ----------------------------
INSERT INTO `sys_embroidery_method` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `sys_facial_makeup`
-- ----------------------------
DROP TABLE IF EXISTS `sys_facial_makeup`;
CREATE TABLE `sys_facial_makeup` (
  `id` bigint NOT NULL COMMENT '主键',
  `facial_makeup` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '脸谱路径\r\n',
  `facial_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '脸谱名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_facial_makeup
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_hair_accessories`
-- ----------------------------
DROP TABLE IF EXISTS `sys_hair_accessories`;
CREATE TABLE `sys_hair_accessories` (
  `id` bigint NOT NULL COMMENT '主键\r\n',
  `hair_Accessories` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发饰路径',
  `hair_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发饰名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_hair_accessories
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_pattern`
-- ----------------------------
DROP TABLE IF EXISTS `sys_pattern`;
CREATE TABLE `sys_pattern` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pattern` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图案路径',
  `pattern_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图案',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_pattern
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_store_list`
-- ----------------------------
DROP TABLE IF EXISTS `sys_store_list`;
CREATE TABLE `sys_store_list` (
  `id` bigint NOT NULL COMMENT '主键',
  `picture` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品图片路径',
  `label` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `price` int NOT NULL COMMENT '价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_store_list
-- ----------------------------

-- ----------------------------
-- Table structure for `user_asset`
-- ----------------------------
DROP TABLE IF EXISTS `user_asset`;
CREATE TABLE `user_asset` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint NOT NULL,
  `coin_number` int NOT NULL DEFAULT '0' COMMENT '金币数量',
  `silkworm_leaves` int NOT NULL DEFAULT '0' COMMENT '蚕丝数量',
  `pupae_number` int NOT NULL DEFAULT '0' COMMENT '蚕蛹数量',
  `fabric_number` int NOT NULL DEFAULT '0' COMMENT '布料数量',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_asset
-- ----------------------------
INSERT INTO `user_asset` VALUES ('1728311928146640898', '1728311928146640897', '0', '0', '0', '0');
INSERT INTO `user_asset` VALUES ('1728378987765317635', '1728378987765317634', '0', '0', '0', '0');
INSERT INTO `user_asset` VALUES ('1728430184169803779', '1728430184169803778', '0', '0', '0', '0');
INSERT INTO `user_asset` VALUES ('1728630967578398723', '1728630967578398722', '0', '0', '0', '0');
INSERT INTO `user_asset` VALUES ('1728672156901990402', '1728672156901990401', '0', '0', '0', '0');
INSERT INTO `user_asset` VALUES ('1728696044390301698', '1728696044390301697', '0', '0', '0', '0');
INSERT INTO `user_asset` VALUES ('1728697951171125249', '1728697951154348033', '0', '0', '0', '0');
INSERT INTO `user_asset` VALUES ('1728978849233956866', '1728978849233956865', '0', '0', '0', '0');
INSERT INTO `user_asset` VALUES ('1728980862336249858', '1728980862336249857', '0', '0', '0', '0');
INSERT INTO `user_asset` VALUES ('1729372517585395714', '1729372517585395713', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(30) NOT NULL,
  `avator` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1728248042986979330', '121', '123456', '鱧栝怢譮噂', null);
INSERT INTO `user_info` VALUES ('1728249887792914434', '12133', '123456', '張旡钏蚐柸', null);
INSERT INTO `user_info` VALUES ('1728254678765989890', '123213123', '123456', '峽颠鋫佴盳', null);
INSERT INTO `user_info` VALUES ('1728256589401423874', 'qwerq', '123456', '窬犊橿鳠耯', null);
INSERT INTO `user_info` VALUES ('1728294326762520578', 'sdafas', '123456', '蟇甈竧歁蝳', null);
INSERT INTO `user_info` VALUES ('1728309447379435522', '黄哲铭', '123456', '廥遱蚥聙擽', null);
INSERT INTO `user_info` VALUES ('1728309734437601281', '黄哲铭帅哥', '123456', '繑苤緁儏頍', null);
INSERT INTO `user_info` VALUES ('1728311928146640897', '黄哲铭帅哥666', '123456', '祈邋尮踍氺', null);
INSERT INTO `user_info` VALUES ('1728378987765317634', '黄哲铭牛逼', '123456', '襒孰栛艡陫', null);
INSERT INTO `user_info` VALUES ('1728430184169803778', '黄哲铭牛逼666', '123456', '喤輎雩璂淾', null);
INSERT INTO `user_info` VALUES ('1728630967578398722', '詹敏是狗', '123456', '鱮硵宋嗦炎', null);
INSERT INTO `user_info` VALUES ('1728672156901990401', '詹敏是狗人', '123456', '蚐毣刓母舦', null);
INSERT INTO `user_info` VALUES ('1728696044390301697', '陈煜', '123456', '褗酴糪幵絛', null);
INSERT INTO `user_info` VALUES ('1728697951154348033', '陈煜人机', '123456', '遾璐趢闥蟻', null);
INSERT INTO `user_info` VALUES ('1728978849233956865', '陈煜人机哈哈哈', '123456', '漚鈕瘬麑檜', null);
INSERT INTO `user_info` VALUES ('1728980862336249857', '陈志新', '123456', '洖勇赱魅蕈', null);
INSERT INTO `user_info` VALUES ('1729372517585395713', '陈志新666', '123456', '陈博', null);

-- ----------------------------
-- Table structure for `user_silkworm_number`
-- ----------------------------
DROP TABLE IF EXISTS `user_silkworm_number`;
CREATE TABLE `user_silkworm_number` (
  `id` bigint NOT NULL,
  `user_id` bigint NOT NULL COMMENT '外健关联用户表',
  `silkworm_color` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '蚕只颜色',
  `silkworm_statu` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '蚕只状态',
  `silkworm_size` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '蚕只大小',
  `silkworm_number` int DEFAULT '0' COMMENT '蚕数量',
  PRIMARY KEY (`id`),
  KEY `user_id_silkworm` (`user_id`),
  CONSTRAINT `user_id_silkworm` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_silkworm_number
-- ----------------------------
INSERT INTO `user_silkworm_number` VALUES ('2', '1728630967578398722', '0', '0', '0', null);
INSERT INTO `user_silkworm_number` VALUES ('1728672156901990403', '1728672156901990401', '红色', '幼蚕', '小', null);
INSERT INTO `user_silkworm_number` VALUES ('1728672156901990404', '1728672156901990401', '绿色', '幼蚕', '小', null);
INSERT INTO `user_silkworm_number` VALUES ('1728672156901990405', '1728672156901990401', '蓝色', '幼蚕', '小', null);
INSERT INTO `user_silkworm_number` VALUES ('1728672156969099265', '1728672156901990401', '粉色', '幼蚕', '小', null);
INSERT INTO `user_silkworm_number` VALUES ('1728696044390301699', '1728696044390301697', '红色', null, null, '0');
INSERT INTO `user_silkworm_number` VALUES ('1728696044390301700', '1728696044390301697', '绿色', null, null, '0');
INSERT INTO `user_silkworm_number` VALUES ('1728696044390301701', '1728696044390301697', '蓝色', null, null, '0');
INSERT INTO `user_silkworm_number` VALUES ('1728696044390301702', '1728696044390301697', '粉色', null, null, '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951171125250', '1728697951154348033', '红色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951171125251', '1728697951154348033', '红色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951171125252', '1728697951154348033', '红色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951171125253', '1728697951154348033', '红色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951171125254', '1728697951154348033', '红色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951234039809', '1728697951154348033', '红色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951234039810', '1728697951154348033', '红色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951234039811', '1728697951154348033', '红色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951234039812', '1728697951154348033', '红色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951234039813', '1728697951154348033', '绿色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951234039814', '1728697951154348033', '绿色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951301148674', '1728697951154348033', '绿色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951301148675', '1728697951154348033', '绿色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951301148676', '1728697951154348033', '绿色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951301148677', '1728697951154348033', '绿色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951301148678', '1728697951154348033', '绿色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951301148679', '1728697951154348033', '绿色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951301148680', '1728697951154348033', '绿色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951301148681', '1728697951154348033', '蓝色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951368257538', '1728697951154348033', '蓝色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951368257539', '1728697951154348033', '蓝色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951368257540', '1728697951154348033', '蓝色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951368257541', '1728697951154348033', '蓝色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951368257542', '1728697951154348033', '蓝色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951368257543', '1728697951154348033', '蓝色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951368257544', '1728697951154348033', '蓝色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951368257545', '1728697951154348033', '蓝色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951368257546', '1728697951154348033', '粉色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951435366401', '1728697951154348033', '粉色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951435366402', '1728697951154348033', '粉色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951435366403', '1728697951154348033', '粉色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951435366404', '1728697951154348033', '粉色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951435366405', '1728697951154348033', '粉色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951435366406', '1728697951154348033', '粉色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951435366407', '1728697951154348033', '粉色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728697951435366408', '1728697951154348033', '粉色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849305260033', '1728978849233956865', '红色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849305260034', '1728978849233956865', '红色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849305260035', '1728978849233956865', '红色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849305260036', '1728978849233956865', '红色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849305260037', '1728978849233956865', '红色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849305260038', '1728978849233956865', '红色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849305260039', '1728978849233956865', '红色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849368174594', '1728978849233956865', '红色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849368174595', '1728978849233956865', '红色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849368174596', '1728978849233956865', '绿色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849368174597', '1728978849233956865', '绿色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849368174598', '1728978849233956865', '绿色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849368174599', '1728978849233956865', '绿色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849368174600', '1728978849233956865', '绿色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849368174601', '1728978849233956865', '绿色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849368174602', '1728978849233956865', '绿色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849435283457', '1728978849233956865', '绿色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849435283458', '1728978849233956865', '绿色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849435283459', '1728978849233956865', '蓝色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849435283460', '1728978849233956865', '蓝色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849435283461', '1728978849233956865', '蓝色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849435283462', '1728978849233956865', '蓝色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849435283463', '1728978849233956865', '蓝色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849435283464', '1728978849233956865', '蓝色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849435283465', '1728978849233956865', '蓝色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849502392322', '1728978849233956865', '蓝色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849502392323', '1728978849233956865', '蓝色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849502392324', '1728978849233956865', '粉色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849502392325', '1728978849233956865', '粉色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849502392326', '1728978849233956865', '粉色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849502392327', '1728978849233956865', '粉色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849502392328', '1728978849233956865', '粉色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849502392329', '1728978849233956865', '粉色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849502392330', '1728978849233956865', '粉色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849502392331', '1728978849233956865', '粉色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728978849565306882', '1728978849233956865', '粉色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862378192898', '1728980862336249857', '红色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862378192899', '1728980862336249857', '红色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862378192900', '1728980862336249857', '红色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862378192901', '1728980862336249857', '红色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862378192902', '1728980862336249857', '红色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862378192903', '1728980862336249857', '红色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862378192904', '1728980862336249857', '红色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862441107458', '1728980862336249857', '红色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862441107459', '1728980862336249857', '红色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862441107460', '1728980862336249857', '绿色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862441107461', '1728980862336249857', '绿色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862441107462', '1728980862336249857', '绿色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862441107463', '1728980862336249857', '绿色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862441107464', '1728980862336249857', '绿色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862508216321', '1728980862336249857', '绿色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862508216322', '1728980862336249857', '绿色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862508216323', '1728980862336249857', '绿色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862508216324', '1728980862336249857', '绿色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862508216325', '1728980862336249857', '蓝色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862508216326', '1728980862336249857', '蓝色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862508216327', '1728980862336249857', '蓝色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862508216328', '1728980862336249857', '蓝色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862508216329', '1728980862336249857', '蓝色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862575325186', '1728980862336249857', '蓝色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862575325187', '1728980862336249857', '蓝色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862575325188', '1728980862336249857', '蓝色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862575325189', '1728980862336249857', '蓝色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862575325190', '1728980862336249857', '粉色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862575325191', '1728980862336249857', '粉色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862575325192', '1728980862336249857', '粉色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862575325193', '1728980862336249857', '粉色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862575325194', '1728980862336249857', '粉色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862638239746', '1728980862336249857', '粉色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862638239747', '1728980862336249857', '粉色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862638239748', '1728980862336249857', '粉色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1728980862638239749', '1728980862336249857', '粉色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517656698882', '1729372517585395713', '红色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517656698883', '1729372517585395713', '红色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517656698884', '1729372517585395713', '红色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517656698885', '1729372517585395713', '红色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517656698886', '1729372517585395713', '红色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517656698887', '1729372517585395713', '红色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517723807745', '1729372517585395713', '红色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517723807746', '1729372517585395713', '红色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517723807747', '1729372517585395713', '红色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517723807748', '1729372517585395713', '绿色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517723807749', '1729372517585395713', '绿色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517723807750', '1729372517585395713', '绿色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517723807751', '1729372517585395713', '绿色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517723807752', '1729372517585395713', '绿色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517786722306', '1729372517585395713', '绿色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517786722307', '1729372517585395713', '绿色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517786722308', '1729372517585395713', '绿色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517786722309', '1729372517585395713', '绿色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517786722310', '1729372517585395713', '蓝色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517786722311', '1729372517585395713', '蓝色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517786722312', '1729372517585395713', '蓝色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517786722313', '1729372517585395713', '蓝色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517786722314', '1729372517585395713', '蓝色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517853831169', '1729372517585395713', '蓝色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517853831170', '1729372517585395713', '蓝色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517853831171', '1729372517585395713', '蓝色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517853831172', '1729372517585395713', '蓝色', '老蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517853831173', '1729372517585395713', '粉色', '幼蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517853831174', '1729372517585395713', '粉色', '青年蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517853831175', '1729372517585395713', '粉色', '老蚕', '大只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517853831176', '1729372517585395713', '粉色', '幼蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517853831177', '1729372517585395713', '粉色', '青年蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517920940034', '1729372517585395713', '粉色', '老蚕', '中只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517920940035', '1729372517585395713', '粉色', '幼蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517920940036', '1729372517585395713', '粉色', '青年蚕', '小只', '0');
INSERT INTO `user_silkworm_number` VALUES ('1729372517920940037', '1729372517585395713', '粉色', '老蚕', '小只', '0');
