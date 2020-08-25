/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - myshop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`myshop` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `myshop`;

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `carid` int(50) NOT NULL AUTO_INCREMENT,
  `uid` int(50) DEFAULT NULL,
  `gid` int(50) DEFAULT NULL,
  `carnum` int(50) DEFAULT NULL,
  `total` int(50) DEFAULT NULL,
  PRIMARY KEY (`carid`),
  KEY `car_fk` (`gid`),
  KEY `car_fk2` (`uid`),
  CONSTRAINT `car_fk` FOREIGN KEY (`gid`) REFERENCES `goods` (`Gid`),
  CONSTRAINT `car_fk2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `car` */

insert  into `car`(`carid`,`uid`,`gid`,`carnum`,`total`) values (3,6,13,1,4399),(4,1,13,1,4399),(5,1,13,1,4399);

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `Gid` int(50) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Tid` int(50) NOT NULL,
  `Price` double(10,2) DEFAULT NULL,
  `Num` int(20) NOT NULL,
  `Address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`Gid`),
  KEY `goodd_fk` (`Tid`),
  CONSTRAINT `goodd_fk` FOREIGN KEY (`Tid`) REFERENCES `goodstype` (`Tid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `goods` */

insert  into `goods`(`Gid`,`Name`,`Tid`,`Price`,`Num`,`Address`) values (11,'卫龙辣条',3,3.00,1,'湖北卫龙集团'),(12,'贤哥毛肚',3,9.00,11,'湖南卫龙集团'),(13,'外星人笔记本',1,4399.00,5,'英特尔'),(14,'小天鹅洗衣机',1,3999.00,20,'小天鹅股份有限公司');

/*Table structure for table `goodstype` */

DROP TABLE IF EXISTS `goodstype`;

CREATE TABLE `goodstype` (
  `Tid` int(50) NOT NULL AUTO_INCREMENT,
  `Tname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`Tid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `goodstype` */

insert  into `goodstype`(`Tid`,`Tname`) values (1,'大型家电'),(3,'食品饮料');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `money` int(20) DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`uid`,`name`,`password`,`money`) values (1,'武则天','123',1230),(2,'狄仁杰','456',4560),(3,'李白','789',7890),(4,'杜甫','987',9780),(5,'李元芳','654',6540),(6,'陆贞','321',3210);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
