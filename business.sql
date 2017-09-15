/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 80000
 Source Host           : localhost
 Source Database       : business

 Target Server Type    : MySQL
 Target Server Version : 80000
 File Encoding         : utf-8

 Date: 09/15/2017 19:01:04 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_name`
-- ----------------------------
DROP TABLE IF EXISTS `t_name`;
CREATE TABLE `t_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_name`
-- ----------------------------
BEGIN;
INSERT INTO `t_name` VALUES ('1', 'song');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
