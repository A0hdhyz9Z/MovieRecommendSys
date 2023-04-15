/*
 Navicat Premium Data Transfer

 Source Server         : tencentCloud
 Source Server Type    : MySQL
 Source Server Version : 50718 (5.7.18-cynos-log)
 Source Host           : bj-cynosdbmysql-grp-og8zp5ro.sql.tencentcdb.com:26956
 Source Schema         : movie

 Target Server Type    : MySQL
 Target Server Version : 50718 (5.7.18-cynos-log)
 File Encoding         : 65001

 Date: 15/04/2023 21:35:59
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
  INDEX `FK52we4afc5f0qeilabyy6eamlr`(`movie1_id`) USING BTREE,
  INDEX `FK4r4kbjbwnckiqv702d7p5kad6`(`movie10_id`) USING BTREE,
  INDEX `FKmsy53kq4ktl9f6iadin8xxm5f`(`movie11_id`) USING BTREE,
  INDEX `FKh9wg6lq0ks941u23nbxd7rum0`(`movie12_id`) USING BTREE,
  INDEX `FK54882qmxiso31rtdyleaocd0f`(`movie13_id`) USING BTREE,
  INDEX `FKfqvt4hvflxdbfxtwklmn042bs`(`movie14_id`) USING BTREE,
  INDEX `FK9og3uyo44peoa32x3xlrdwmiq`(`movie15_id`) USING BTREE,
  INDEX `FK2ptfn8o3dywsdihlglkcmqhk8`(`movie16_id`) USING BTREE,
  INDEX `FK4kqqerfyycuk6h9fe3x1nkdyu`(`movie17_id`) USING BTREE,
  INDEX `FKfsvhr93d0qwh7php6jmrja4id`(`movie18_id`) USING BTREE,
  INDEX `FK7y53yxwdaometcc3jt86pvqij`(`movie19_id`) USING BTREE,
  INDEX `FKhfp67e9msyhdi7ebvtcmnkvtk`(`movie2_id`) USING BTREE,
  INDEX `FK2sqg19nx6khs7w5olybpl3ter`(`movie20_id`) USING BTREE,
  INDEX `FKf6wxmcwi5xogmbjcqg979b4j5`(`movie3_id`) USING BTREE,
  INDEX `FK2lmo2q7rw0i7stdqjf3my286h`(`movie4_id`) USING BTREE,
  INDEX `FK2aeho1qcmaxnxhmm2ijb7snb2`(`movie5_id`) USING BTREE,
  INDEX `FKnj57b3sulrv55ro4dcbkwc12m`(`movie6_id`) USING BTREE,
  INDEX `FK3wol1srw5ryvxunf44x26fnxb`(`movie7_id`) USING BTREE,
  INDEX `FKbau3ps6mk357klqysti9fpcip`(`movie8_id`) USING BTREE,
  INDEX `FK3kt1v8mjaq1u5amhf71tnrxn3`(`movie9_id`) USING BTREE
);
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_1` FOREIGN KEY (`movie1_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_2` FOREIGN KEY (`movie2_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_3` FOREIGN KEY (`movie3_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_4` FOREIGN KEY (`movie4_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_5` FOREIGN KEY (`movie5_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_6` FOREIGN KEY (`movie6_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_7` FOREIGN KEY (`movie7_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_8` FOREIGN KEY (`movie8_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_9` FOREIGN KEY (`movie9_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_10` FOREIGN KEY (`movie10_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_11` FOREIGN KEY (`movie11_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_12` FOREIGN KEY (`movie12_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_13` FOREIGN KEY (`movie13_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_14` FOREIGN KEY (`movie14_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_15` FOREIGN KEY (`movie15_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_16` FOREIGN KEY (`movie16_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_17` FOREIGN KEY (`movie17_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_18` FOREIGN KEY (`movie18_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_19` FOREIGN KEY (`movie19_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_20` FOREIGN KEY (`movie20_id`) REFERENCES `movies` (`movieId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `recommendation` ADD CONSTRAINT `recommendation_ibfk_21` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

