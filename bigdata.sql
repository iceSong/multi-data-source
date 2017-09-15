/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 80000
 Source Host           : localhost
 Source Database       : bigdata

 Target Server Type    : MySQL
 Target Server Version : 80000
 File Encoding         : utf-8

 Date: 09/15/2017 19:00:58 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_age`
-- ----------------------------
DROP TABLE IF EXISTS `t_age`;
CREATE TABLE `t_age` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `t_age`
-- ----------------------------
BEGIN;
INSERT INTO `t_age` VALUES ('1', '24');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
