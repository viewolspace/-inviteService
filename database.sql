/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.6.40-log : Database - invite
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`invite` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `invite`;

/*Table structure for table `prize_time` */

DROP TABLE IF EXISTS `prize_time`;

CREATE TABLE `prize_time` (
  `num` int(11) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `next_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `m_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `prize_time` */

insert  into `prize_time`(`num`,`start_time`,`next_time`,`m_time`) values (5,'2019-05-22','2019-06-02 06:33:08','2019-05-30 16:35:45');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(200) CHARACTER SET latin1 NOT NULL,
  `third_id` varchar(200) CHARACTER SET latin1 NOT NULL,
  `game_result` int(11) DEFAULT '0' COMMENT '0 未完成 1 已完成',
  `commit_status` int(11) DEFAULT '0' COMMENT '0 未成交  1 已成交',
  `nick_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `head_pic` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `c_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `m_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`uid`,`open_id`,`third_id`,`game_result`,`commit_status`,`nick_name`,`head_pic`,`c_time`,`m_time`) values (3,'openid','ThirdId',1,1,'昵称','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2411564211,2114787003&fm=173&app=25&f=JPEG?w=218&h=146&s=FEF23DC48E462F5754ECC8830300D0C3','2019-05-22 16:27:29','2019-05-22 16:27:29'),(4,'openid1','ThirdId1',0,1,'昵称','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2411564211,2114787003&fm=173&app=25&f=JPEG?w=218&h=146&s=FEF23DC48E462F5754ECC8830300D0C3','2019-05-22 16:16:41','2019-05-22 16:16:41'),(5,'openid2','ThirdId2',0,1,'昵称','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2411564211,2114787003&fm=173&app=25&f=JPEG?w=218&h=146&s=FEF23DC48E462F5754ECC8830300D0C3','2019-05-22 16:17:27','2019-05-22 16:17:27'),(6,'openid3','ThirdId3',0,1,'昵称','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2411564211,2114787003&fm=173&app=25&f=JPEG?w=218&h=146&s=FEF23DC48E462F5754ECC8830300D0C3','2019-05-22 16:18:21','2019-05-22 16:18:21'),(7,'openid4','ThirdId4',0,1,'昵称','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2411564211,2114787003&fm=173&app=25&f=JPEG?w=218&h=146&s=FEF23DC48E462F5754ECC8830300D0C3','2019-05-22 16:26:22','2019-05-22 16:26:22');

/*Table structure for table `user_detail` */

DROP TABLE IF EXISTS `user_detail`;

CREATE TABLE `user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `open_id` varchar(200) DEFAULT NULL,
  `third_id` varchar(200) DEFAULT NULL,
  `nick_name` varchar(200) DEFAULT NULL,
  `c_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `prize` int(11) DEFAULT '0' COMMENT '0 未中奖 ， 其他中奖编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `user_detail` */

insert  into `user_detail`(`id`,`uid`,`open_id`,`third_id`,`nick_name`,`c_time`,`prize`) values (1,3,'openid','ThirdId','昵称','2019-05-22 16:29:44',0),(2,7,'openid4','ThirdId4','昵称','2019-05-22 16:31:08',1),(3,7,'openid4','ThirdId4','昵称','2019-05-24 16:32:17',0),(4,7,'openid4','ThirdId4','昵称','2019-05-24 16:33:10',0),(5,3,'openid','ThirdId','昵称','2019-05-24 16:33:49',1),(6,3,'openid','ThirdId','昵称','2019-05-28 16:34:58',1),(7,3,'openid','ThirdId','昵称','2019-05-30 16:35:45',1);

/*Table structure for table `user_invite` */

DROP TABLE IF EXISTS `user_invite`;

CREATE TABLE `user_invite` (
  `uid` int(11) NOT NULL,
  `third_id` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `open_id` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `nick_name` varchar(200) DEFAULT NULL,
  `invite_uid` int(11) DEFAULT NULL,
  `invite_third_id` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `invite_open_id` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `invite_nick_name` varchar(200) DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '0 未成交 1 已成交',
  `c_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `m_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `user_invite` */

insert  into `user_invite`(`uid`,`third_id`,`open_id`,`nick_name`,`invite_uid`,`invite_third_id`,`invite_open_id`,`invite_nick_name`,`status`,`c_time`,`m_time`) values (7,'ThirdId4','openid4','昵称',3,'ThirdId','openid','昵称',1,'2019-05-22 16:26:22','2019-05-22 16:26:22');

/*Table structure for table `user_summary` */

DROP TABLE IF EXISTS `user_summary`;

CREATE TABLE `user_summary` (
  `uid` int(11) NOT NULL COMMENT 'user表的id',
  `times` int(11) DEFAULT NULL COMMENT '抽奖次数',
  `use_times` int(11) DEFAULT NULL COMMENT '使用的次数',
  `all_times` int(11) DEFAULT NULL COMMENT '总获取多少次抽奖机会',
  `grand_prize` int(11) DEFAULT '1' COMMENT '1 没有获得大奖 2 获得大奖',
  `c_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `m_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `user_summary` */

insert  into `user_summary`(`uid`,`times`,`use_times`,`all_times`,`grand_prize`,`c_time`,`m_time`,`version`) values (3,9,4,13,1,'2019-05-30 16:35:45','2019-05-30 16:35:45',0),(7,8,3,11,1,'2019-05-24 16:32:53','2019-05-24 16:32:52',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
