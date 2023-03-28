/*
 Navicat Premium Data Transfer

 Source Server         : tencentMysql
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : bj-cynosdbmysql-grp-og8zp5ro.sql.tencentcdb.com:26956
 Source Schema         : movie

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 10/03/2023 17:43:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for actor
-- ----------------------------
DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor`  (
  `actorId` int(11) NOT NULL COMMENT '演员ID',
  `actorName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '演员姓名',
  `gender` binary(1) NULL DEFAULT NULL COMMENT '演员性别',
  PRIMARY KEY (`actorId`) USING BTREE,
  INDEX `id`(`actorId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for cast
-- ----------------------------
DROP TABLE IF EXISTS `cast`;
CREATE TABLE `cast`  (
  `order` int(11) NULL DEFAULT NULL COMMENT '演员顺次',
  `character` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '演员扮演角色名',
  `castId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电影演员ID',
  `actorId` int(11) NOT NULL COMMENT '演员ID',
  `profilePath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '演员概要地址url',
  `movieId` int(11) NULL DEFAULT NULL COMMENT '电影ID',
  INDEX `movie`(`movieId`) USING BTREE,
  INDEX `actorid`(`actorId`) USING BTREE,
  CONSTRAINT `actorid` FOREIGN KEY (`actorId`) REFERENCES `actor` (`actorId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `movie` FOREIGN KEY (`movieId`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for crew
-- ----------------------------
DROP TABLE IF EXISTS `crew`;
CREATE TABLE `crew`  (
  `workerId` int(11) NOT NULL COMMENT '职工ID',
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门名称',
  `job` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工作职位',
  `movieId` int(11) NOT NULL COMMENT '电影ID',
  `profilePath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '职工概要地址url',
  `creditId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Credit ID',
  INDEX `movieID`(`movieId`) USING BTREE,
  INDEX `workerid`(`workerId`) USING BTREE,
  CONSTRAINT `movieID` FOREIGN KEY (`movieId`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `workerid` FOREIGN KEY (`workerId`) REFERENCES `worker` (`workerId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for genre
-- ----------------------------
DROP TABLE IF EXISTS `genre`;
CREATE TABLE `genre`  (
  `movieId` int(11) NOT NULL COMMENT '电影ID',
  `genreId` int(11) NULL DEFAULT NULL COMMENT '体裁ID',
  INDEX `movie`(`movieId`) USING BTREE,
  INDEX `genre`(`genreId`) USING BTREE,
  CONSTRAINT `genreId-genre` FOREIGN KEY (`genreId`) REFERENCES `genrehub` (`genreId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `movieId-genre` FOREIGN KEY (`movieId`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for genrehub
-- ----------------------------
DROP TABLE IF EXISTS `genrehub`;
CREATE TABLE `genrehub`  (
  `genreId` int(11) NOT NULL COMMENT '体裁ID',
  `genreName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '体裁名称',
  PRIMARY KEY (`genreId`) USING BTREE,
  INDEX `genre`(`genreId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for keyword
-- ----------------------------
DROP TABLE IF EXISTS `keyword`;
CREATE TABLE `keyword`  (
  `movieID` int(11) NOT NULL COMMENT '电影ID',
  `keywordID` int(11) NOT NULL COMMENT '关键词ID',
  PRIMARY KEY (`movieID`) USING BTREE,
  INDEX `keyid`(`keywordID`) USING BTREE,
  CONSTRAINT `keyid` FOREIGN KEY (`keywordID`) REFERENCES `taghub` (`keywordID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `keymovie` FOREIGN KEY (`movieID`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for movies
-- ----------------------------
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies`  (
  `movieId` int(11) NOT NULL COMMENT '电影ID',
  `adult` tinyint(1) NULL DEFAULT NULL COMMENT '是否为adult',
  `budget` bigint(20) NULL DEFAULT NULL COMMENT '预算金额',
  `homepage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '主页地址url',
  `originalLanguage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '原片语言',
  `originalTitle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '原片标题',
  `popularity` float NULL DEFAULT NULL COMMENT '知名度',
  `posterPath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '海报地址url',
  `releaseDate` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '放映日期',
  `revenue` bigint(20) NULL DEFAULT NULL COMMENT '收入金额',
  `runtime` int(11) NULL DEFAULT NULL COMMENT '放映时间',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
  `tagline` mediumblob NULL COMMENT '电影理念',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电影标题',
  `video` tinyint(1) NOT NULL COMMENT '是否有视频',
  `voteAverage` float NULL DEFAULT NULL COMMENT '平均评分得分',
  `voteCount` int(11) NULL DEFAULT NULL COMMENT '总评分数',
  `overview` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`movieId`) USING BTREE,
  INDEX `movieId`(`movieId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for rate
-- ----------------------------
DROP TABLE IF EXISTS `rate`;
CREATE TABLE `rate`  (
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `rating` float NULL DEFAULT NULL COMMENT '评分',
  `movieId` int(11) NULL DEFAULT NULL COMMENT '电影ID',
  INDEX `usermovie`(`movieId`) USING BTREE,
  INDEX `user-rate`(`userId`) USING BTREE,
  CONSTRAINT `movie-rate` FOREIGN KEY (`movieId`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user-rate` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for taghub
-- ----------------------------
DROP TABLE IF EXISTS `taghub`;
CREATE TABLE `taghub`  (
  `keywordID` int(11) NOT NULL COMMENT '关键字ID',
  `keywordName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '关键字名字',
  PRIMARY KEY (`keywordID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`  (
  `workerId` int(11) NOT NULL COMMENT '职工ID',
  `workerName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '职工姓名',
  `gender` binary(1) NULL DEFAULT NULL COMMENT '职工性别',
  PRIMARY KEY (`workerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
