/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-01-05 16:34:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_param
-- ----------------------------
DROP TABLE IF EXISTS `sys_param`;
CREATE TABLE `sys_param` (
  `company_id` int(8) NOT NULL COMMENT '经销商编码',
  `param_key` int(8) NOT NULL COMMENT '参数键',
  `param_name` varchar(32) DEFAULT NULL COMMENT '参数名称',
  `param_desc` varchar(64) DEFAULT NULL COMMENT '参数描述',
  `param_value` int(8) DEFAULT NULL COMMENT '参数值',
  `param_unit` varchar(16) DEFAULT NULL,
  `created_by` int(8) DEFAULT NULL,
  `created_time` timestamp(6) NULL DEFAULT NULL,
  `updated_by` int(8) DEFAULT NULL,
  `updated_time` timestamp(6) NULL DEFAULT NULL,
  `is_inactive` int(1) DEFAULT '0' COMMENT '停用状态',
  `version` int(8) DEFAULT '0',
  PRIMARY KEY (`param_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='违规参数表';

-- ----------------------------
-- Records of sys_param
-- ----------------------------
INSERT INTO `sys_param` VALUES ('1007', '1000', '试驾车电子围栏半径范围', '试驾车电子围栏半径范围', '5', '公里', null, '2017-10-19 12:32:42.000000', '1674', '2017-11-23 14:49:38.000000', '0', '21');
INSERT INTO `sys_param` VALUES ('1007', '1001', '试驾车行驶出电子围栏连续超过X小时记录违规', '试驾车行驶出电子围栏连续超过X小时记录违规', '5', '小时', null, '2017-10-13 16:15:09.673174', '1674', '2017-11-14 10:23:29.000000', '0', '17');
INSERT INTO `sys_param` VALUES ('1007', '1002', '试驾车行驶出电子围栏违规后每隔X小时发送信息', '试驾车行驶出电子围栏违规后每隔X小时发送信息', '48', '小时', null, '2017-10-19 12:37:07.000000', '1674', '2017-11-09 14:08:02.000000', '0', '4');
INSERT INTO `sys_param` VALUES ('1007', '1003', '试驾车超过Y天未启动预警', '试驾车超过Y天未启动预警', '3', '天', null, '2017-11-14 09:28:47.000000', '1674', '2017-11-14 10:18:47.000000', '0', '2');
INSERT INTO `sys_param` VALUES ('1007', '1004', '试驾车超过X天未启动计入一次违规', '试驾车超过X天未启动计入一次违规，X天必须大于Y天', '4', '天', null, '2017-10-13 16:15:10.812282', '1674', '2017-11-22 17:30:56.000000', '0', '11');
INSERT INTO `sys_param` VALUES ('1007', '1005', '试驾车未启动违规后每隔X天发送信息', '试驾车未启动违规后每隔X天发送信息', '3', '天', null, '2017-10-19 12:38:20.000000', '1674', '2017-11-07 16:28:22.000000', '0', '6');
INSERT INTO `sys_param` VALUES ('1007', '1006', '试驾车可达最大行驶速度', '试驾车在行驶过程中可达到的速度上限', '100', '公里/时', null, '2017-11-23 10:46:05.000000', '1674', '2017-11-29 16:20:29.000000', '0', '1');
