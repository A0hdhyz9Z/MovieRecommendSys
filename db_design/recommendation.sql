/*
 Navicat Premium Data Transfer

 Source Server         : tencentCloud
 Source Server Type    : MySQL
 Source Server Version : 50718 (5.7.18-cynos-log)
 Source Host           : bj-cynosdbmysql-grp-og8zp5ro.sql.tencentcdb.com:26956
 Source Schema         : movie_test

 Target Server Type    : MySQL
 Target Server Version : 50718 (5.7.18-cynos-log)
 File Encoding         : 65001

 Date: 15/04/2023 21:53:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for recommendation
-- ----------------------------
DROP TABLE IF EXISTS `recommendation`;
CREATE TABLE `recommendation`  (
  `id` int(11) NOT NULL,
  `movie1_id` int(11) NULL DEFAULT NULL,
  `movie10_id` int(11) NULL DEFAULT NULL,
  `movie11_id` int(11) NULL DEFAULT NULL,
  `movie12_id` int(11) NULL DEFAULT NULL,
  `movie13_id` int(11) NULL DEFAULT NULL,
  `movie14_id` int(11) NULL DEFAULT NULL,
  `movie15_id` int(11) NULL DEFAULT NULL,
  `movie16_id` int(11) NULL DEFAULT NULL,
  `movie17_id` int(11) NULL DEFAULT NULL,
  `movie18_id` int(11) NULL DEFAULT NULL,
  `movie19_id` int(11) NULL DEFAULT NULL,
  `movie2_id` int(11) NULL DEFAULT NULL,
  `movie20_id` int(11) NULL DEFAULT NULL,
  `movie3_id` int(11) NULL DEFAULT NULL,
  `movie4_id` int(11) NULL DEFAULT NULL,
  `movie5_id` int(11) NULL DEFAULT NULL,
  `movie6_id` int(11) NULL DEFAULT NULL,
  `movie7_id` int(11) NULL DEFAULT NULL,
  `movie8_id` int(11) NULL DEFAULT NULL,
  `movie9_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKishts61puoct4tyxuog2ids3m`(`movie1_id`) USING BTREE,
  INDEX `FK9vaou6ovtvrorbos8y1hytxl2`(`movie10_id`) USING BTREE,
  INDEX `FKxfjdvwoidu3ygbcobisp8t9o`(`movie11_id`) USING BTREE,
  INDEX `FKruc7ranos1q24n4mbqyf8j5dh`(`movie12_id`) USING BTREE,
  INDEX `FK2lof79xwl40gjxaa773lvdha3`(`movie13_id`) USING BTREE,
  INDEX `FKg9uednxwn0kdh0hgfwgvai7mn`(`movie14_id`) USING BTREE,
  INDEX `FKbjfbor8j5irtt6lf7x1jotyyc`(`movie15_id`) USING BTREE,
  INDEX `FKn4gj6plwj71hqq09xooa4vsvp`(`movie16_id`) USING BTREE,
  INDEX `FK4cpw5d25encraucp00he8vlm9`(`movie17_id`) USING BTREE,
  INDEX `FKsj05mams2y9al3ukfraxxrcu4`(`movie18_id`) USING BTREE,
  INDEX `FK4t4s79xumjdah2tp1ap6gmt6l`(`movie19_id`) USING BTREE,
  INDEX `FKqbhvywgynsw02o6wafvkntprw`(`movie2_id`) USING BTREE,
  INDEX `FKb6ayoy5vae7ef0nqlhwkabywe`(`movie20_id`) USING BTREE,
  INDEX `FKm1klf440j9eqr71vwpuvrvsj5`(`movie3_id`) USING BTREE,
  INDEX `FKp41busi8ybnt8b1c7javf26kj`(`movie4_id`) USING BTREE,
  INDEX `FK39lx3vwvmr6sawype343srnh2`(`movie5_id`) USING BTREE,
  INDEX `FKoar2lu9x1c52yc9pw4m46887f`(`movie6_id`) USING BTREE,
  INDEX `FKbemfs61semmkge2rianw1i6yv`(`movie7_id`) USING BTREE,
  INDEX `FKk8urrb0tom5w9htuf0if2m2lb`(`movie8_id`) USING BTREE,
  INDEX `FK62a2gd7r3gd9agn7qs1ic3cxu`(`movie9_id`) USING BTREE,
  CONSTRAINT `FK2lof79xwl40gjxaa773lvdha3` FOREIGN KEY (`movie13_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK39lx3vwvmr6sawype343srnh2` FOREIGN KEY (`movie5_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK4cpw5d25encraucp00he8vlm9` FOREIGN KEY (`movie17_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK4t4s79xumjdah2tp1ap6gmt6l` FOREIGN KEY (`movie19_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK62a2gd7r3gd9agn7qs1ic3cxu` FOREIGN KEY (`movie9_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK9vaou6ovtvrorbos8y1hytxl2` FOREIGN KEY (`movie10_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKb6ayoy5vae7ef0nqlhwkabywe` FOREIGN KEY (`movie20_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKbemfs61semmkge2rianw1i6yv` FOREIGN KEY (`movie7_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKbjfbor8j5irtt6lf7x1jotyyc` FOREIGN KEY (`movie15_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKg9uednxwn0kdh0hgfwgvai7mn` FOREIGN KEY (`movie14_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKishts61puoct4tyxuog2ids3m` FOREIGN KEY (`movie1_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKk8urrb0tom5w9htuf0if2m2lb` FOREIGN KEY (`movie8_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKm1klf440j9eqr71vwpuvrvsj5` FOREIGN KEY (`movie3_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKn4gj6plwj71hqq09xooa4vsvp` FOREIGN KEY (`movie16_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKoar2lu9x1c52yc9pw4m46887f` FOREIGN KEY (`movie6_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKp41busi8ybnt8b1c7javf26kj` FOREIGN KEY (`movie4_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKqbhvywgynsw02o6wafvkntprw` FOREIGN KEY (`movie2_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKruc7ranos1q24n4mbqyf8j5dh` FOREIGN KEY (`movie12_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKsj05mams2y9al3ukfraxxrcu4` FOREIGN KEY (`movie18_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKxfjdvwoidu3ygbcobisp8t9o` FOREIGN KEY (`movie11_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
