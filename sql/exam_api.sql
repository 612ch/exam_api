/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50505
 Source Host           : localhost:3306
 Source Schema         : exam_api

 Target Server Type    : MySQL
 Target Server Version : 50505
 File Encoding         : 65001

 Date: 18/12/2020 23:15:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classinfo
-- ----------------------------
DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo`  (
  `classId` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gradeId` int(11) NOT NULL,
  `teacherId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`classId`) USING BTREE,
  INDEX `teacherId`(`teacherId`) USING BTREE,
  INDEX `FK_Reference_1`(`gradeId`) USING BTREE,
  CONSTRAINT `classinfo_ibfk_1` FOREIGN KEY (`teacherId`) REFERENCES `teacherinfo` (`teacherId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`gradeId`) REFERENCES `gradeinfo` (`gradeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for courseinfo
-- ----------------------------
DROP TABLE IF EXISTS `courseinfo`;
CREATE TABLE `courseinfo`  (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `division` int(11) NULL DEFAULT 0,
  `gradeId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`courseId`) USING BTREE,
  INDEX `gradeId`(`gradeId`) USING BTREE,
  CONSTRAINT `courseinfo_ibfk_1` FOREIGN KEY (`gradeId`) REFERENCES `gradeinfo` (`gradeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for examchooseinfo
-- ----------------------------
DROP TABLE IF EXISTS `examchooseinfo`;
CREATE TABLE `examchooseinfo`  (
  `chooseId` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL,
  `examPaperId` int(11) NOT NULL,
  `subjectId` int(11) NOT NULL,
  `chooseResult` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`chooseId`) USING BTREE,
  INDEX `FK_Reference_11`(`studentId`) USING BTREE,
  INDEX `FK_Reference_12`(`examPaperId`) USING BTREE,
  INDEX `FK_Reference_13`(`subjectId`) USING BTREE,
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`studentId`) REFERENCES `studentinfo` (`studentId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`examPaperId`) REFERENCES `exampaperinfo` (`examPaperId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`subjectId`) REFERENCES `subjectinfo` (`subjectId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for examhistoryinfo
-- ----------------------------
DROP TABLE IF EXISTS `examhistoryinfo`;
CREATE TABLE `examhistoryinfo`  (
  `historyId` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL,
  `examPaperId` int(11) NOT NULL,
  `examScore` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`historyId`) USING BTREE,
  INDEX `FK_Reference_10`(`studentId`) USING BTREE,
  INDEX `FK_Reference_9`(`examPaperId`) USING BTREE,
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`studentId`) REFERENCES `studentinfo` (`studentId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`examPaperId`) REFERENCES `exampaperinfo` (`examPaperId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for exampaperinfo
-- ----------------------------
DROP TABLE IF EXISTS `exampaperinfo`;
CREATE TABLE `exampaperinfo`  (
  `examPaperId` int(11) NOT NULL AUTO_INCREMENT,
  `examPaperName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `subjectNum` int(11) NOT NULL,
  `examPaperTime` int(11) NOT NULL,
  `examPaperScore` int(11) NOT NULL,
  `gradeId` int(11) NOT NULL,
  `division` int(11) NULL DEFAULT 0,
  `examPaperEasy` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`examPaperId`) USING BTREE,
  INDEX `FK_Reference_4`(`gradeId`) USING BTREE,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`gradeId`) REFERENCES `gradeinfo` (`gradeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for examplaninfo
-- ----------------------------
DROP TABLE IF EXISTS `examplaninfo`;
CREATE TABLE `examplaninfo`  (
  `examPlanId` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NOT NULL,
  `classId` int(11) NOT NULL,
  `examPaperId` int(11) NOT NULL,
  `beginTime` datetime NULL,
  PRIMARY KEY (`examPlanId`) USING BTREE,
  INDEX `courseId`(`courseId`) USING BTREE,
  INDEX `classId`(`classId`) USING BTREE,
  INDEX `examPaperId`(`examPaperId`) USING BTREE,
  CONSTRAINT `examplaninfo_ibfk_1` FOREIGN KEY (`courseId`) REFERENCES `courseinfo` (`courseId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `examplaninfo_ibfk_2` FOREIGN KEY (`classId`) REFERENCES `classinfo` (`classId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `examplaninfo_ibfk_3` FOREIGN KEY (`examPaperId`) REFERENCES `exampaperinfo` (`examPaperId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for examsubjectmiddleinfo
-- ----------------------------
DROP TABLE IF EXISTS `examsubjectmiddleinfo`;
CREATE TABLE `examsubjectmiddleinfo`  (
  `esmId` int(11) NOT NULL AUTO_INCREMENT,
  `examPaperId` int(11) NOT NULL,
  `subjectId` int(11) NOT NULL,
  PRIMARY KEY (`esmId`) USING BTREE,
  INDEX `FK_Reference_7`(`examPaperId`) USING BTREE,
  INDEX `FK_Reference_8`(`subjectId`) USING BTREE,
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`examPaperId`) REFERENCES `exampaperinfo` (`examPaperId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`subjectId`) REFERENCES `subjectinfo` (`subjectId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for gradeinfo
-- ----------------------------
DROP TABLE IF EXISTS `gradeinfo`;
CREATE TABLE `gradeinfo`  (
  `gradeId` int(11) NOT NULL AUTO_INCREMENT,
  `gradeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`gradeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for studentinfo
-- ----------------------------
DROP TABLE IF EXISTS `studentinfo`;
CREATE TABLE `studentinfo`  (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `studentAccount` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `studentPwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `classId` int(11) NOT NULL,
  PRIMARY KEY (`studentId`) USING BTREE,
  INDEX `FK_Reference_3`(`classId`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`classId`) REFERENCES `classinfo` (`classId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for subjectinfo
-- ----------------------------
DROP TABLE IF EXISTS `subjectinfo`;
CREATE TABLE `subjectinfo`  (
  `subjectId` int(11) NOT NULL AUTO_INCREMENT,
  `subjectName` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `optionA` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `optionB` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `optionC` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `optionD` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rightResult` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `subjectScore` int(11) NOT NULL,
  `subjectType` int(11) NULL DEFAULT 0,
  `courseId` int(11) NOT NULL,
  `gradeId` int(11) NOT NULL,
  `subjectEasy` int(11) NULL DEFAULT 1,
  `division` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`subjectId`) USING BTREE,
  INDEX `FK_Reference_5`(`courseId`) USING BTREE,
  INDEX `FK_Reference_6`(`gradeId`) USING BTREE,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`courseId`) REFERENCES `courseinfo` (`courseId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`gradeId`) REFERENCES `gradeinfo` (`gradeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6547 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teacherinfo
-- ----------------------------
DROP TABLE IF EXISTS `teacherinfo`;
CREATE TABLE `teacherinfo`  (
  `teacherId` int(11) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacherAccount` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacherPwd` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminPower` int(11) NULL DEFAULT 0,
  `isWork` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`teacherId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
