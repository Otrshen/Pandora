/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : pandora

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 08/05/2021 17:21:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for email
-- ----------------------------
DROP TABLE IF EXISTS `email`;
CREATE TABLE `email` (
                         `msgUID` varchar(255) DEFAULT NULL,
                         `subject` varchar(255) DEFAULT NULL,
                         `emailAddress` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for imgbed
-- ----------------------------
DROP TABLE IF EXISTS `imgbed`;
CREATE TABLE `imgbed` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `type` int NOT NULL,
                          `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '使用JSON字符串保存不同图床的不同字段',
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `type` (`type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for subscribe_email
-- ----------------------------
DROP TABLE IF EXISTS `subscribe_email`;
CREATE TABLE `subscribe_email` (
                                   `id` int NOT NULL AUTO_INCREMENT,
                                   `email` varchar(255) DEFAULT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
