/*
Navicat MySQL Data Transfer

Source Server         : battlecall
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : ugdb

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-07-29 23:20:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for boxinfo
-- ----------------------------
DROP TABLE IF EXISTS `boxinfo`;
CREATE TABLE `boxinfo` (
  `boxId` int(11) NOT NULL AUTO_INCREMENT,
  `boxStatus` tinyint(4) DEFAULT '0',
  `boxType` tinyint(4) DEFAULT NULL,
  `cabinetId` int(11) DEFAULT NULL,
  PRIMARY KEY (`boxId`),
  KEY `cabinetId` (`cabinetId`),
  CONSTRAINT `cabinetId` FOREIGN KEY (`cabinetId`) REFERENCES `cabinet` (`cabinetId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boxinfo
-- ----------------------------

-- ----------------------------
-- Table structure for boxlocation
-- ----------------------------
DROP TABLE IF EXISTS `boxlocation`;
CREATE TABLE `boxlocation` (
  `boxlocationId` int(11) NOT NULL AUTO_INCREMENT,
  `boxSchoolId` int(11) DEFAULT NULL,
  `boxlocationName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`boxlocationId`),
  KEY `boxSchool` (`boxSchoolId`),
  CONSTRAINT `boxSchool` FOREIGN KEY (`boxSchoolId`) REFERENCES `school` (`schoolId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boxlocation
-- ----------------------------

-- ----------------------------
-- Table structure for boxuserecord
-- ----------------------------
DROP TABLE IF EXISTS `boxuserecord`;
CREATE TABLE `boxuserecord` (
  `recordId` int(11) NOT NULL AUTO_INCREMENT,
  `boxId` int(11) DEFAULT NULL,
  `userId` varchar(32) DEFAULT NULL,
  `start_time` bigint(20) DEFAULT NULL,
  `end_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`recordId`),
  KEY `boxId` (`boxId`),
  KEY `userId` (`userId`),
  CONSTRAINT `boxId` FOREIGN KEY (`boxId`) REFERENCES `boxinfo` (`boxId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boxuserecord
-- ----------------------------

-- ----------------------------
-- Table structure for cabinet
-- ----------------------------
DROP TABLE IF EXISTS `cabinet`;
CREATE TABLE `cabinet` (
  `cabinetId` int(11) NOT NULL AUTO_INCREMENT,
  `boxLocationId` int(11) DEFAULT NULL,
  PRIMARY KEY (`cabinetId`),
  KEY `boxLocationId` (`boxLocationId`),
  CONSTRAINT `boxLocationId` FOREIGN KEY (`boxLocationId`) REFERENCES `boxlocation` (`boxlocationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cabinet
-- ----------------------------

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `majorId` int(11) NOT NULL AUTO_INCREMENT,
  `majorName` varchar(20) DEFAULT NULL,
  `schoolId` int(11) DEFAULT NULL,
  PRIMARY KEY (`majorId`),
  KEY `schoolId` (`schoolId`),
  CONSTRAINT `schoolId` FOREIGN KEY (`schoolId`) REFERENCES `school` (`schoolId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `schoolId` int(11) NOT NULL AUTO_INCREMENT,
  `schoolName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`schoolId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(32) NOT NULL,
  `userPhone` varchar(11) DEFAULT NULL,
  `userSex` bit(1) DEFAULT NULL,
  `userBalance` decimal(10,2) DEFAULT NULL,
  `userBoxtime` bigint(20) DEFAULT NULL,
  `userMajorId` int(11) DEFAULT NULL,
  `usersignDays` int(11) DEFAULT NULL,
  `lastsignTime` date DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `userMajorId` (`userMajorId`),
  CONSTRAINT `userMajorId` FOREIGN KEY (`userMajorId`) REFERENCES `major` (`majorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
