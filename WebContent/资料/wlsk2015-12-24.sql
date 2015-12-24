/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.20 : Database - wlsk
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wlsk` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `wlsk`;

/*Table structure for table `security_base` */

DROP TABLE IF EXISTS `security_base`;

CREATE TABLE `security_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `version` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `security_base` */

insert  into `security_base`(`id`,`name`,`version`) values (1,'铜陵地税','v1.0');

/*Table structure for table `security_menu` */

DROP TABLE IF EXISTS `security_menu`;

CREATE TABLE `security_menu` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `code` varchar(50) DEFAULT NULL COMMENT '菜单编码',
  `description` varchar(500) DEFAULT NULL COMMENT '菜单描述',
  `orderlist` int(11) DEFAULT NULL COMMENT '排序号',
  `img` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `url` varchar(150) DEFAULT NULL COMMENT '跳转url',
  `parent_id` int(111) DEFAULT NULL COMMENT '父节点',
  `type` int(50) DEFAULT NULL COMMENT '菜单类型',
  `status` int(4) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `security_menu` */

insert  into `security_menu`(`id`,`name`,`code`,`description`,`orderlist`,`img`,`url`,`parent_id`,`type`,`status`) values (1,'税控基础设置','123',NULL,1,'/res/images/leftico01.png',NULL,0,NULL,NULL),(2,'纳税户信息管理',NULL,NULL,NULL,NULL,'/skqnsrxx/list.htm',1,NULL,NULL),(3,'纳税人名称更新',NULL,NULL,NULL,NULL,'/taxpayer/toImport.htm',1,NULL,NULL),(4,'发票管理',NULL,NULL,2,'/res/images/leftico02.png',NULL,0,NULL,NULL),(5,'发票购买',NULL,NULL,NULL,NULL,'/skqfpj/toFpgm.htm',4,NULL,NULL),(6,'系统管理',NULL,NULL,4,'/res/images/leftico04.png',NULL,0,NULL,NULL),(7,'发票票种管理',NULL,NULL,NULL,NULL,'/skqfp/list.htm',6,NULL,NULL),(8,'品目设置',NULL,NULL,NULL,NULL,'/skqpmsz/list.htm',6,NULL,NULL),(9,'机器型号管理',NULL,NULL,NULL,NULL,'/skqjqxh/list.htm',6,NULL,NULL),(10,'注册类型管理',NULL,NULL,NULL,NULL,'/skqzclx/list.htm',6,NULL,NULL),(11,'行业及明细管理',NULL,NULL,NULL,NULL,'/skqhy/list.htm',6,NULL,NULL),(12,'税务机关管理',NULL,NULL,NULL,NULL,'/securityorganization/list.htm',6,NULL,NULL),(13,'用户管理',NULL,NULL,NULL,NULL,'/securityuser/list.htm',6,NULL,NULL),(14,'角色权限管理',NULL,NULL,NULL,NULL,'/securityrole/list.htm',6,NULL,NULL),(15,'申报数据',NULL,NULL,3,'/res/images/leftico03.png','',0,NULL,NULL),(16,'自然月申报',NULL,NULL,NULL,NULL,'/skqsbsj/toZrysb.htm',15,NULL,NULL),(17,'阶段申报',NULL,'爱爱爱',NULL,NULL,'/skqsbsj/toJdsb.htm',15,NULL,NULL),(18,'监控回传',NULL,NULL,NULL,NULL,'/skqsbsj/toJkhc.htm',15,NULL,NULL),(20,'查询统计',NULL,NULL,5,'/res/images/leftico04.png',NULL,0,NULL,NULL),(21,'纳税户信息查询',NULL,NULL,NULL,NULL,'/skqnsrxx/listcxtj.htm',20,NULL,NULL),(22,'税控装置查询',NULL,NULL,NULL,NULL,'/skqjqxx/listcxtj.htm',20,NULL,NULL),(23,'发票领购查询',NULL,NULL,NULL,NULL,'/skqfpjmx/list.htm',20,NULL,NULL),(24,'申报汇总查询',NULL,NULL,NULL,NULL,'/skqsbsj/list.htm',20,NULL,NULL),(26,'用户卡信息读取',NULL,NULL,NULL,NULL,'/cxtj/toYhkImport.htm',20,NULL,NULL),(27,'税控卡信息读取',NULL,NULL,NULL,NULL,'/cxtj/toSkkImport.htm',20,NULL,NULL),(28,'税控卡复制',NULL,NULL,NULL,NULL,'/cxtj/toSkkFz.htm',20,NULL,NULL),(29,'菜单管理',NULL,NULL,NULL,NULL,'/securitymenu/list.htm',6,NULL,NULL),(30,'通知通告管理',NULL,NULL,NULL,NULL,'/securitynews/list.htm',6,NULL,NULL);

/*Table structure for table `security_news` */

DROP TABLE IF EXISTS `security_news`;

CREATE TABLE `security_news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT '通告标题',
  `content` text COMMENT '通告内容',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `status` int(11) DEFAULT NULL COMMENT '是否启用',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `security_news` */

insert  into `security_news`(`id`,`title`,`content`,`userid`,`status`,`ctime`) values (2,'大唐税控后台成功上线！','<p class=\"MsoNormal\" align=\"left\" style=\"font-family:Simsun;font-size:medium;background-color:#FFFFFF;\">\r\n	大唐税控后台成功上线！\r\n</p>',4,1,'2015-12-24 17:39:18');

/*Table structure for table `security_organization` */

DROP TABLE IF EXISTS `security_organization`;

CREATE TABLE `security_organization` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `code` varchar(50) DEFAULT NULL COMMENT '编码',
  `name` varchar(100) DEFAULT NULL COMMENT '机构名称',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `parent_id` int(50) DEFAULT NULL COMMENT '上级机构',
  `status` varchar(10) DEFAULT NULL COMMENT '状态',
  `orderlist` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `security_organization` */

insert  into `security_organization`(`id`,`code`,`name`,`description`,`parent_id`,`status`,`orderlist`) values (40,'000001','总局','总局',0,'1',NULL),(41,'000002','分局1','分局1',40,'1',NULL),(42,'000003','分局2','分局2',40,'1',NULL);

/*Table structure for table `security_organization_user` */

DROP TABLE IF EXISTS `security_organization_user`;

CREATE TABLE `security_organization_user` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) DEFAULT NULL,
  `organization_id` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `security_organization_user` */

/*Table structure for table `security_role` */

DROP TABLE IF EXISTS `security_role`;

CREATE TABLE `security_role` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL COMMENT '编码',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(500) DEFAULT NULL COMMENT '角色描述',
  `status` int(10) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `security_role` */

insert  into `security_role`(`id`,`code`,`name`,`description`,`status`) values (9,'SYSTEM','系统管理员',NULL,1),(10,'FPGM','发票购买',NULL,1),(11,'SBWH','申报维护',NULL,1);

/*Table structure for table `security_role_menu` */

DROP TABLE IF EXISTS `security_role_menu`;

CREATE TABLE `security_role_menu` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(50) DEFAULT NULL,
  `menu_id` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

/*Data for the table `security_role_menu` */

insert  into `security_role_menu`(`id`,`role_id`,`menu_id`) values (12,5,17),(13,5,18),(14,5,15),(15,6,21),(16,6,20),(17,6,0),(18,6,17),(19,6,18),(20,6,15),(25,2,17),(26,2,18),(27,2,15),(126,4,22),(127,4,23),(128,4,24),(129,4,25),(130,4,26),(131,4,27),(132,4,28),(133,4,29),(134,4,30),(135,4,10),(136,4,11),(137,4,12),(138,4,13),(139,4,14),(140,4,15),(141,4,16),(142,4,17),(143,4,18),(144,4,0),(145,4,1),(146,4,2),(147,4,3),(148,4,4),(149,4,5),(150,4,6),(151,4,7),(152,4,8),(153,4,9),(154,4,20),(155,4,21),(156,7,0),(157,7,15),(158,7,16),(159,7,17),(160,7,18),(161,8,0),(162,8,4),(163,8,5),(164,9,22),(165,9,23),(166,9,24),(167,9,25),(168,9,26),(169,9,27),(170,9,28),(171,9,29),(172,9,10),(173,9,11),(174,9,12),(175,9,13),(176,9,14),(177,9,15),(178,9,16),(179,9,17),(180,9,18),(181,9,0),(182,9,1),(183,9,2),(184,9,3),(185,9,4),(186,9,5),(187,9,6),(188,9,7),(189,9,8),(190,9,9),(191,9,20),(192,9,21),(193,10,0),(194,10,4),(195,10,5),(196,11,0),(197,11,15),(198,11,16),(199,11,17),(200,11,18);

/*Table structure for table `security_user` */

DROP TABLE IF EXISTS `security_user`;

CREATE TABLE `security_user` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `code` varchar(50) DEFAULT NULL COMMENT '代码',
  `username` varchar(200) DEFAULT NULL COMMENT '姓名',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `userpwd` varchar(100) DEFAULT NULL COMMENT '密码',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机',
  `realname` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `status` int(100) DEFAULT NULL COMMENT '状态',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  `organization_id` int(50) DEFAULT NULL COMMENT '组织id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `security_user` */

insert  into `security_user`(`id`,`code`,`username`,`email`,`userpwd`,`phone`,`realname`,`status`,`ctime`,`organization_id`) values (4,NULL,'system','gepp2010@163.com','c4ca4238a0b923820dcc509a6f75849b','18952028230','葛萍萍',0,NULL,NULL),(8,NULL,'xiaoming','xiaoming@qq.com','c4ca4238a0b923820dcc509a6f75849b',NULL,'小明',1,'2015-12-07 22:26:31',37);

/*Table structure for table `security_user_ext` */

DROP TABLE IF EXISTS `security_user_ext`;

CREATE TABLE `security_user_ext` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) DEFAULT NULL,
  `organization_id` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `security_user_ext` */

/*Table structure for table `security_user_role` */

DROP TABLE IF EXISTS `security_user_role`;

CREATE TABLE `security_user_role` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(32) DEFAULT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `security_user_role` */

insert  into `security_user_role`(`id`,`user_id`,`role_id`) values (11,8,'10');

/*Table structure for table `skq_bdc` */

DROP TABLE IF EXISTS `skq_bdc`;

CREATE TABLE `skq_bdc` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `XMMC` varchar(200) DEFAULT NULL COMMENT '项目名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `CJZ` varchar(20) DEFAULT NULL COMMENT '创建者',
  `CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `SWJGBM` varchar(20) DEFAULT NULL COMMENT '税务机关编码',
  `NSRWJBM` varchar(20) DEFAULT NULL COMMENT '纳税人微机编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_bdc` */

/*Table structure for table `skq_bdckp` */

DROP TABLE IF EXISTS `skq_bdckp`;

CREATE TABLE `skq_bdckp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PARENTID` int(11) DEFAULT NULL COMMENT '楼牌ID',
  `LPMC` varchar(100) DEFAULT NULL COMMENT '楼牌号',
  `FKFMC` varchar(100) DEFAULT NULL COMMENT '付款方名称',
  `FKFDM` varchar(100) DEFAULT NULL COMMENT '付款方代码',
  `NSRWJBM` varchar(20) DEFAULT NULL COMMENT '纳税人微机编码',
  `JQBH` varchar(20) DEFAULT NULL COMMENT '机器编号',
  `HJZJE` decimal(16,2) DEFAULT NULL COMMENT '开票金额',
  `KXXZ` int(11) DEFAULT NULL COMMENT '款项性质',
  `FPDM` varchar(20) DEFAULT NULL COMMENT '发票代码',
  `FPHM` int(11) DEFAULT NULL COMMENT '发票号码',
  `KPLX` int(11) DEFAULT NULL COMMENT '开票类型',
  `KPRQ` datetime DEFAULT NULL COMMENT '开票日期',
  `SCRQ` datetime DEFAULT NULL COMMENT '上传日期',
  `BDCID` int(11) DEFAULT NULL COMMENT '项目ID',
  `BDCZXMID` int(11) DEFAULT NULL COMMENT '子项目ID',
  `BDCXMMXID` int(11) DEFAULT NULL COMMENT '项目明细ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_bdckp` */

/*Table structure for table `skq_bdclp` */

DROP TABLE IF EXISTS `skq_bdclp`;

CREATE TABLE `skq_bdclp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PARENTID` int(11) DEFAULT NULL COMMENT '项目明细ID',
  `LPMC` varchar(100) DEFAULT NULL COMMENT '楼牌号',
  `LC` int(11) DEFAULT NULL COMMENT '楼层',
  `LPXH` int(11) DEFAULT NULL COMMENT '楼牌序号',
  `MJ` decimal(16,2) DEFAULT NULL COMMENT '面积',
  `DJ` decimal(16,2) DEFAULT NULL COMMENT '单价',
  `LX` int(11) DEFAULT NULL COMMENT '类型',
  `CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `NSRWJBM` varchar(20) DEFAULT NULL COMMENT '纳税人微机编码',
  `YKJE` decimal(16,2) DEFAULT NULL COMMENT '已开金额',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_bdclp` */

/*Table structure for table `skq_bdcmm` */

DROP TABLE IF EXISTS `skq_bdcmm`;

CREATE TABLE `skq_bdcmm` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NSRWJBM` varchar(20) DEFAULT NULL COMMENT '纳税人微机编码',
  `PASSWORD` varchar(32) DEFAULT NULL COMMENT '密码',
  `CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_bdcmm` */

/*Table structure for table `skq_bdcxmmx` */

DROP TABLE IF EXISTS `skq_bdcxmmx`;

CREATE TABLE `skq_bdcxmmx` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PARENTID` int(11) DEFAULT NULL COMMENT '子项目ID',
  `XMMC` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XMBM` varchar(20) DEFAULT NULL COMMENT '项目编码',
  `BZXPTZZTS` int(11) DEFAULT NULL COMMENT '保障性普通住宅套数',
  `FBZXPTZZTS` int(11) DEFAULT NULL COMMENT '非保障性普通住宅套数',
  `FPTZZTS` int(11) DEFAULT NULL COMMENT '非普通住宅套数',
  `BSTS` int(11) DEFAULT NULL COMMENT '别墅套数',
  `SPTS` int(11) DEFAULT NULL COMMENT '商铺套数',
  `XZLTS` int(11) DEFAULT NULL COMMENT '写字楼套数',
  `QTTS` int(11) DEFAULT NULL COMMENT '其他套数',
  `BZXPTZZMJ` decimal(16,2) DEFAULT NULL COMMENT '保障性普通住宅面积',
  `FBZXPTZZMJ` decimal(16,2) DEFAULT NULL COMMENT '非保障性普通住宅面积',
  `FPTZZMJ` decimal(16,2) DEFAULT NULL COMMENT '非普通住宅面积',
  `BSMJ` decimal(16,2) DEFAULT NULL COMMENT '别墅面积',
  `SPMJ` decimal(16,2) DEFAULT NULL COMMENT '商铺面积',
  `XZLMJ` decimal(16,2) DEFAULT NULL COMMENT '写字楼面积',
  `QTMJ` decimal(16,2) DEFAULT NULL COMMENT '其他面积',
  `CJZ` varchar(20) DEFAULT NULL COMMENT '创建者',
  `CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `NSRWJBM` varchar(20) DEFAULT NULL COMMENT '纳税人微机编码',
  `ZXMMC` varchar(200) DEFAULT NULL COMMENT '主项目名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_bdcxmmx` */

/*Table structure for table `skq_bdczxm` */

DROP TABLE IF EXISTS `skq_bdczxm`;

CREATE TABLE `skq_bdczxm` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PARENTID` int(11) DEFAULT NULL COMMENT '主项目ID',
  `XMMC` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `ZGSWJG` varchar(20) DEFAULT NULL COMMENT '税务机关编码',
  `CJZ` varchar(20) DEFAULT NULL COMMENT '创建者',
  `CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `NSRWJBM` varchar(20) DEFAULT NULL COMMENT '纳税人微机编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_bdczxm` */

/*Table structure for table `skq_dhde` */

DROP TABLE IF EXISTS `skq_dhde`;

CREATE TABLE `skq_dhde` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `JQBH` varchar(16) NOT NULL COMMENT '机器编号',
  `DZKPXE` decimal(16,2) NOT NULL COMMENT '机器编号',
  `YLJKPXE` decimal(16,2) NOT NULL COMMENT '月累计开票限额',
  `YLJTPXE` decimal(16,2) NOT NULL COMMENT '月累计开票限额',
  `QYBZ` int(11) NOT NULL COMMENT '启用标示',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_dhde` */

/*Table structure for table `skq_fp` */

DROP TABLE IF EXISTS `skq_fp`;

CREATE TABLE `skq_fp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `FPBM` varchar(20) DEFAULT NULL COMMENT '票种编码',
  `FPMC` varchar(100) DEFAULT NULL COMMENT '票种名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_fp` */

insert  into `skq_fp`(`id`,`FPBM`,`FPMC`,`STATUS`) values (2,'001','地税普通发票',1);

/*Table structure for table `skq_fpj` */

DROP TABLE IF EXISTS `skq_fpj`;

CREATE TABLE `skq_fpj` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `FPBM` varchar(20) NOT NULL COMMENT '发票编码',
  `FPDM` varchar(20) NOT NULL COMMENT '发票编码',
  `FPQSH` int(11) NOT NULL COMMENT '发票起始号码',
  `FPJZH` int(11) NOT NULL COMMENT '发票截止号码',
  `FPDW` int(11) NOT NULL COMMENT '发票单位',
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `FPLGRQ` datetime DEFAULT NULL COMMENT '发票领购日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `skq_fpj` */

insert  into `skq_fpj`(`id`,`FPBM`,`FPDM`,`FPQSH`,`FPJZH`,`FPDW`,`NSRWJBM`,`FPLGRQ`) values (10,'001','111111111111',1,100,1,'1','2015-12-16 10:44:42'),(11,'001','111111111111',201,300,1,'1','2015-12-16 10:47:19'),(12,'001','111111111111',1,100,1,'1','2015-12-16 10:50:54'),(13,'001','111111111111',401,1400,10,'1','2015-12-16 10:51:51'),(14,'001','132000000001',1,100,1,'0000000000000001','2015-12-18 11:44:22'),(15,'001','132000000001',1,100,1,'0000000000000001','2015-12-18 11:44:34'),(16,'001','132000000001',101,200,1,'0000000000000001','2015-12-18 11:44:46'),(17,'001','132000000001',301,400,1,'0000000000000001','2015-12-18 11:44:55'),(18,'001','132000000001',1001,1100,1,'0000000000000001','2015-12-24 09:53:11'),(19,'001','132000000001',1201,2200,10,'0000000000000001','2015-12-24 23:54:51');

/*Table structure for table `skq_fpjmx` */

DROP TABLE IF EXISTS `skq_fpjmx`;

CREATE TABLE `skq_fpjmx` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `FPBM` varchar(20) NOT NULL COMMENT '发票编码',
  `FPDM` varchar(20) NOT NULL COMMENT '发票编码',
  `FPQSH` int(11) NOT NULL COMMENT '发票起始号',
  `FPJZH` int(11) NOT NULL COMMENT '发票截止号',
  `FPDW` int(11) NOT NULL COMMENT '发票单位',
  `JQBH` varchar(16) DEFAULT NULL COMMENT '机器编号',
  `FPXFZT` int(11) NOT NULL COMMENT '发票下发状态',
  `FPLGZT` int(11) NOT NULL COMMENT '发票领购状态',
  `MXSCZT` int(11) NOT NULL COMMENT '明细上传状态',
  `FPLGRQ` datetime DEFAULT NULL COMMENT '发票领购日期',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `skq_fpjmx` */

insert  into `skq_fpjmx`(`ID`,`NSRWJBM`,`FPBM`,`FPDM`,`FPQSH`,`FPJZH`,`FPDW`,`JQBH`,`FPXFZT`,`FPLGZT`,`MXSCZT`,`FPLGRQ`) values (3,'1','001','111111111111',201,300,1,'',0,1,0,'2015-12-16 10:47:19'),(5,'1','001','111111111111',401,500,1,'',0,1,0,'2015-12-16 10:51:52'),(6,'1','001','111111111111',501,600,1,'',0,1,0,'2015-12-16 10:51:52'),(7,'1','001','111111111111',601,700,1,'',0,1,0,'2015-12-16 10:51:52'),(8,'1','001','111111111111',701,800,1,'',0,1,0,'2015-12-16 10:51:52'),(9,'0000000000000001','001','132000000001',1,100,1,'',1,1,0,'2015-12-18 11:44:22'),(11,'0000000000000001','001','132000000001',101,200,1,'',1,1,0,'2015-12-18 11:44:46'),(12,'0000000000000001','001','132000000001',301,400,1,'',1,1,0,'2015-12-18 11:44:55'),(13,'0000000000000001','001','132000000001',1001,1100,1,'',1,1,0,'2015-12-24 09:53:11'),(14,'0000000000000001','001','132000000001',1201,1300,1,'',0,1,0,'2015-12-24 23:54:51'),(15,'0000000000000001','001','132000000001',1301,1400,1,'',0,1,0,'2015-12-24 23:54:51'),(16,'0000000000000001','001','132000000001',1401,1500,1,'',0,1,0,'2015-12-24 23:54:51'),(17,'0000000000000001','001','132000000001',1501,1600,1,'',0,1,0,'2015-12-24 23:54:51'),(18,'0000000000000001','001','132000000001',1601,1700,1,'',0,1,0,'2015-12-24 23:54:51'),(19,'0000000000000001','001','132000000001',1701,1800,1,'',0,1,0,'2015-12-24 23:54:51'),(20,'0000000000000001','001','132000000001',1801,1900,1,'',0,1,0,'2015-12-24 23:54:51'),(21,'0000000000000001','001','132000000001',1901,2000,1,'',0,1,0,'2015-12-24 23:54:51'),(22,'0000000000000001','001','132000000001',2001,2100,1,'',0,1,0,'2015-12-24 23:54:51');

/*Table structure for table `skq_fpkj` */

DROP TABLE IF EXISTS `skq_fpkj`;

CREATE TABLE `skq_fpkj` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `JQBH` varchar(16) NOT NULL COMMENT '机器编号',
  `KPRQ` datetime DEFAULT NULL COMMENT '开票日期',
  `KPLX` int(11) DEFAULT NULL COMMENT '开票类型',
  `FPDM` varchar(20) NOT NULL COMMENT '发票代码',
  `FPHM` int(11) NOT NULL COMMENT '发票号码',
  `HJZJE` decimal(16,2) DEFAULT NULL COMMENT '开票金额',
  `YFPHM` int(11) DEFAULT NULL COMMENT '原发票号码',
  `FKDW` varchar(50) DEFAULT NULL COMMENT '付款单位',
  `SKY` varchar(20) DEFAULT NULL COMMENT '收款员',
  `XMS` int(11) DEFAULT NULL COMMENT '项目数',
  `SKM` varchar(20) DEFAULT NULL COMMENT '税控码',
  `QRBZ` int(11) NOT NULL COMMENT '确认标志',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `SCSJ` datetime DEFAULT NULL COMMENT '上传时间',
  `BZ` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_fpkj` */

/*Table structure for table `skq_fpkjxm` */

DROP TABLE IF EXISTS `skq_fpkjxm`;

CREATE TABLE `skq_fpkjxm` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `PARENTID` int(11) NOT NULL COMMENT '发票开具ID',
  `XMMC` varchar(50) NOT NULL COMMENT '项目名称',
  `XSWS` int(11) NOT NULL COMMENT '小数位数',
  `SL` decimal(16,2) NOT NULL COMMENT '数量',
  `DJ` decimal(16,2) NOT NULL COMMENT '单价',
  `JE` decimal(16,2) NOT NULL COMMENT '金额',
  `SMBM` varchar(20) NOT NULL COMMENT '税目编码',
  `JSXM` int(11) DEFAULT NULL COMMENT '计税项目',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_fpkjxm` */

/*Table structure for table `skq_hy` */

DROP TABLE IF EXISTS `skq_hy`;

CREATE TABLE `skq_hy` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `HYBM` varchar(20) DEFAULT NULL COMMENT '行业编码',
  `HYMC` varchar(100) DEFAULT NULL COMMENT '行业名称',
  `HYJC` varchar(50) DEFAULT NULL COMMENT '行业简称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_hy` */

insert  into `skq_hy`(`id`,`HYBM`,`HYMC`,`HYJC`,`STATUS`) values (1,'001','服务业','服务业',1),(2,'002','娱乐','娱乐',1);

/*Table structure for table `skq_hymx` */

DROP TABLE IF EXISTS `skq_hymx`;

CREATE TABLE `skq_hymx` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `HYID` int(11) DEFAULT NULL COMMENT '行业编码ID',
  `HYBM` varchar(20) DEFAULT NULL COMMENT '行业编码',
  `HYMXBM` varchar(20) DEFAULT NULL COMMENT '行业明细编码',
  `HYMXMC` varchar(100) DEFAULT NULL COMMENT '行业明细名称',
  `HYMXJC` varchar(50) DEFAULT NULL COMMENT '行业明细简称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_hymx` */

insert  into `skq_hymx`(`id`,`HYID`,`HYBM`,`HYMXBM`,`HYMXMC`,`HYMXJC`,`STATUS`) values (1,1,'001','0001','洗脚','洗脚',1),(4,2,'001','001','唱歌','唱歌',1);

/*Table structure for table `skq_hzsj` */

DROP TABLE IF EXISTS `skq_hzsj`;

CREATE TABLE `skq_hzsj` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `YEAR` int(11) NOT NULL COMMENT '年',
  `MONTH` int(11) NOT NULL COMMENT '月',
  `ZCPFS` int(11) NOT NULL COMMENT '正常票份数',
  `TPFS` int(11) NOT NULL COMMENT '退票份数',
  `FPFS` int(11) NOT NULL COMMENT '废票份数',
  `ZCPZJE` decimal(16,2) NOT NULL COMMENT '正常票总金额',
  `TPZJE` decimal(16,2) NOT NULL COMMENT '退票总金额',
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `HZRQ` datetime DEFAULT NULL COMMENT '汇总日期',
  `CLBZ` int(11) DEFAULT NULL COMMENT '处理标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_hzsj` */

/*Table structure for table `skq_hzsjmx` */

DROP TABLE IF EXISTS `skq_hzsjmx`;

CREATE TABLE `skq_hzsjmx` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `PARENTID` int(11) NOT NULL COMMENT '申报汇总ID',
  `SMBM` varchar(20) NOT NULL COMMENT '税目编码',
  `KPJE` decimal(16,2) NOT NULL COMMENT '开票金额',
  `DKJE` decimal(16,2) DEFAULT NULL COMMENT '抵扣金额',
  `YHDYYE` decimal(16,2) DEFAULT NULL COMMENT '月核定营业额',
  `FLAG` int(11) DEFAULT NULL COMMENT '标示',
  `SBJE` decimal(16,2) DEFAULT NULL COMMENT '申报金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_hzsjmx` */

/*Table structure for table `skq_jksjkz` */

DROP TABLE IF EXISTS `skq_jksjkz`;

CREATE TABLE `skq_jksjkz` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `TZYY` varchar(500) NOT NULL COMMENT '原因',
  `TZSJ` datetime NOT NULL COMMENT '限制时间',
  `CJZ` varchar(20) NOT NULL COMMENT '创建者',
  `STATUS` int(11) NOT NULL COMMENT '状态',
  `KFSJ` datetime DEFAULT NULL COMMENT '开放时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_jksjkz` */

/*Table structure for table `skq_jqszsm` */

DROP TABLE IF EXISTS `skq_jqszsm`;

CREATE TABLE `skq_jqszsm` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `JQBH` varchar(16) NOT NULL COMMENT '机器编号',
  `SMBM` varchar(20) NOT NULL COMMENT '税目编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

/*Data for the table `skq_jqszsm` */

insert  into `skq_jqszsm`(`id`,`JQBH`,`SMBM`) values (14,'0000000000000002','00000004'),(15,'0000000000000002','00000005'),(47,'0000000000000123','10000001'),(48,'0000000000000123','00000002'),(49,'0000000000000123','00000003'),(50,'0000000000000123','00000004'),(51,'0000000000000123','00000005'),(56,'0000000000000001','10000001'),(57,'0000000000000001','00000003'),(58,'0000000000000001','00000004'),(59,'0000000000000001','00000005');

/*Table structure for table `skq_jqxh` */

DROP TABLE IF EXISTS `skq_jqxh`;

CREATE TABLE `skq_jqxh` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `JQXHBM` varchar(20) DEFAULT NULL COMMENT '机器型号编码',
  `JQXHMC` varchar(100) DEFAULT NULL COMMENT '机器型号名称',
  `SCCS` varchar(100) DEFAULT NULL COMMENT '生产厂商',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_jqxh` */

insert  into `skq_jqxh`(`id`,`JQXHBM`,`JQXHMC`,`SCCS`,`STATUS`) values (1,'DT0001','机器型号','公司1',1),(2,'DT0002','型号2',NULL,1);

/*Table structure for table `skq_jqxx` */

DROP TABLE IF EXISTS `skq_jqxx`;

CREATE TABLE `skq_jqxx` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `JQXHBM` varchar(20) NOT NULL COMMENT '机器型号编码',
  `JQBH` varchar(16) NOT NULL COMMENT '机器编号',
  `SKKH` varchar(16) NOT NULL COMMENT '税控卡号',
  `YHKH` varchar(16) NOT NULL COMMENT '用户卡号',
  `KQYRQ` datetime NOT NULL COMMENT '卡启用日期',
  `KYXRQ` datetime NOT NULL COMMENT '卡有效日期',
  `SBFS` varchar(2) NOT NULL COMMENT '申报方式',
  `MXSBBZ` varchar(2) NOT NULL COMMENT '明细申报标志',
  `KPJZRQ` datetime NOT NULL COMMENT '开票截止日期',
  `DZKPXE` decimal(16,2) NOT NULL COMMENT '单张开票限额',
  `YLJKPXE` decimal(16,2) NOT NULL COMMENT '月累计开票限额',
  `YLJTPXE` decimal(16,2) NOT NULL COMMENT '月累计开票限额',
  `STATUS` int(11) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `skq_jqxx` */

insert  into `skq_jqxx`(`id`,`NSRWJBM`,`JQXHBM`,`JQBH`,`SKKH`,`YHKH`,`KQYRQ`,`KYXRQ`,`SBFS`,`MXSBBZ`,`KPJZRQ`,`DZKPXE`,`YLJKPXE`,`YLJTPXE`,`STATUS`) values (3,'0000000000000001','DT0001','0000000000000001','0000000000000002','0000000000000003','2015-12-18 00:00:00','2020-12-31 00:00:00','1','1','2016-01-29 00:00:00','1000011.00','1000011.00','10011.00',1);

/*Table structure for table `skq_jsgz` */

DROP TABLE IF EXISTS `skq_jsgz`;

CREATE TABLE `skq_jsgz` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `SWJGBM` varchar(8) NOT NULL COMMENT '税务机关编码',
  `SMBM` varchar(8) NOT NULL COMMENT '税目编码',
  `SMJC` varchar(20) DEFAULT NULL COMMENT '税目简称',
  `TZBS` int(11) NOT NULL COMMENT '特征标示',
  `JSGZ` varchar(200) DEFAULT NULL COMMENT '计税规则',
  `QYBJ` int(11) DEFAULT NULL COMMENT '启用标示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_jsgz` */

/*Table structure for table `skq_jzaz` */

DROP TABLE IF EXISTS `skq_jzaz`;

CREATE TABLE `skq_jzaz` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `PARENTID` int(11) NOT NULL COMMENT '上级项目ID',
  `XMDM` varchar(50) NOT NULL COMMENT '项目代码',
  `XMMC` varchar(100) NOT NULL COMMENT '项目名称',
  `ZGSWJG` varchar(20) NOT NULL COMMENT '税务机关编码',
  `JFWJBM` varchar(20) DEFAULT NULL COMMENT '甲方微机编码',
  `JFMC` varchar(100) NOT NULL COMMENT '甲方名称',
  `YFWJBM` varchar(20) DEFAULT NULL COMMENT '乙方微机编码',
  `YFMC` varchar(100) NOT NULL COMMENT '乙方名称',
  `XMLX` int(11) NOT NULL COMMENT '项目类型',
  `HTXZ` int(11) NOT NULL COMMENT '合同性质',
  `GCK` decimal(16,2) NOT NULL COMMENT '工程款',
  `JGC` decimal(16,2) NOT NULL COMMENT '甲供材',
  `CJZ` varchar(20) DEFAULT NULL COMMENT '创建者',
  `CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `YKJE` decimal(16,2) DEFAULT NULL COMMENT '登记已开金额',
  `NSRXZ` int(11) DEFAULT NULL COMMENT '纳税人性质',
  `DDKJE` decimal(16,2) DEFAULT NULL COMMENT '待抵扣金额',
  `XMZT` int(11) DEFAULT NULL COMMENT '项目状态',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_jzaz` */

/*Table structure for table `skq_jzazkp` */

DROP TABLE IF EXISTS `skq_jzazkp`;

CREATE TABLE `skq_jzazkp` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `PARENTID` int(11) DEFAULT NULL COMMENT '项目ID',
  `KXXZ` int(11) DEFAULT NULL COMMENT '款项性质',
  `FPDM` varchar(20) DEFAULT NULL COMMENT '发票代码',
  `FPHM` int(11) DEFAULT NULL COMMENT '发票号码',
  `KPLX` int(11) DEFAULT NULL COMMENT '开票类型',
  `HJZJE` decimal(16,2) DEFAULT NULL COMMENT '开票金额',
  `KPRQ` datetime DEFAULT NULL COMMENT '开票日期',
  `SCRQ` datetime DEFAULT NULL COMMENT '上传日期',
  `JSXM` int(11) DEFAULT NULL,
  `SFDK` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_jzazkp` */

/*Table structure for table `skq_nsrszsm` */

DROP TABLE IF EXISTS `skq_nsrszsm`;

CREATE TABLE `skq_nsrszsm` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `SZBM` varchar(20) NOT NULL COMMENT '税种编码',
  `SMBM` varchar(20) NOT NULL COMMENT '税种编码',
  `SMMC` varchar(100) NOT NULL COMMENT '税种编码',
  `SMJC` varchar(50) NOT NULL COMMENT '税种编码',
  `SL` decimal(9,2) NOT NULL COMMENT '税率',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

/*Data for the table `skq_nsrszsm` */

insert  into `skq_nsrszsm`(`id`,`NSRWJBM`,`SZBM`,`SMBM`,`SMMC`,`SMJC`,`SL`,`STATUS`) values (54,'000002','0001','10000001','77#汽油','77#汽油','5.00',1),(55,'000002','0002','00000001','93#汽油','93#汽油','5.00',1),(56,'000002','00003','00000003','34汽油','34汽油','5.00',1),(57,'000002','0004','00000004','啊啊啊啊汽油','啊','4.00',1),(58,'000002','0005','00000005','阿德法大赛阿三发','5','5.00',1),(84,'0000000000000001','0001','10000001','服务业','服务业','5.00',1),(85,'0000000000000001','0001','00000002','餐饮业','餐饮业','5.00',1),(86,'0000000000000001','0001','00000003','娱乐业','娱乐业','5.00',1),(87,'0000000000000001','0001','00000004','休闲业','休闲业','4.00',1),(88,'0000000000000001','0001','00000005','建筑安装业','建筑安装业','5.00',1);

/*Table structure for table `skq_nsrxx` */

DROP TABLE IF EXISTS `skq_nsrxx`;

CREATE TABLE `skq_nsrxx` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `NSRSBH` varchar(20) DEFAULT NULL COMMENT '纳税人识别号',
  `NSRMC` varchar(100) NOT NULL COMMENT '纳税人名称',
  `JYDZ` varchar(200) DEFAULT NULL COMMENT '经营地址',
  `FRDB` varchar(20) DEFAULT NULL COMMENT '法人代表',
  `ZCLXBM` varchar(20) DEFAULT NULL COMMENT '注册类型编码',
  `HYBM` varchar(20) DEFAULT NULL COMMENT '行业编码',
  `HYMXBM` varchar(20) DEFAULT NULL COMMENT '行业明细编码',
  `ZSFS` int(11) NOT NULL COMMENT '征收方式',
  `YHDE` decimal(16,2) DEFAULT NULL COMMENT '月核定营业额',
  `SWJGBM` varchar(20) NOT NULL COMMENT '税务机关编码',
  `BSY` varchar(20) DEFAULT NULL COMMENT '办税员',
  `SSGLY` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `STATUS` int(11) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_nsrxx` */

insert  into `skq_nsrxx`(`id`,`NSRWJBM`,`NSRSBH`,`NSRMC`,`JYDZ`,`FRDB`,`ZCLXBM`,`HYBM`,`HYMXBM`,`ZSFS`,`YHDE`,`SWJGBM`,`BSY`,`SSGLY`,`STATUS`) values (4,'0000000000000001','32048219880804053X','金坛（集团）','圩塘新村64栋','葛萍萍','00001','001','0001',1,'400000.00','000003','老财','老财',1);

/*Table structure for table `skq_pmbg` */

DROP TABLE IF EXISTS `skq_pmbg`;

CREATE TABLE `skq_pmbg` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `JQBH` varchar(16) NOT NULL COMMENT '机器编号',
  `YSMBM` varchar(100) NOT NULL COMMENT '原税目编码',
  `BGSMBM` varchar(100) NOT NULL COMMENT '变更税目编码',
  `BGSM` varchar(200) DEFAULT NULL COMMENT '变更说明',
  `SQSJ` datetime NOT NULL COMMENT '申请时间',
  `CLBZ` int(11) NOT NULL COMMENT '申请时间',
  `CLZ` varchar(20) DEFAULT NULL COMMENT '处理者',
  `CLYJ` varchar(200) DEFAULT NULL COMMENT '处理意见',
  `CLSJ` datetime DEFAULT NULL COMMENT '处理意见',
  `XZBS` int(11) DEFAULT NULL COMMENT '处理意见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_pmbg` */

/*Table structure for table `skq_pmsz` */

DROP TABLE IF EXISTS `skq_pmsz`;

CREATE TABLE `skq_pmsz` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `SZBM` varchar(10) DEFAULT NULL COMMENT '税种编码',
  `SMBM` varchar(10) DEFAULT NULL COMMENT '税目编码',
  `SMMC` varchar(100) DEFAULT NULL COMMENT '税目名称',
  `SMJC` varchar(20) DEFAULT NULL COMMENT '税目简称',
  `SL` decimal(16,2) DEFAULT NULL COMMENT '税率',
  `SMSY` int(11) DEFAULT NULL COMMENT '税目索引',
  `FPBM` varchar(100) DEFAULT NULL COMMENT '票种编码',
  `HDKPBL` int(11) DEFAULT NULL COMMENT '核定户开票限额比例',
  `CZKPXE` decimal(16,2) DEFAULT NULL COMMENT '查账征收户开票限额',
  `CEZS` int(11) DEFAULT NULL COMMENT '是否差额征收',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_pmsz` */

insert  into `skq_pmsz`(`id`,`SZBM`,`SMBM`,`SMMC`,`SMJC`,`SL`,`SMSY`,`FPBM`,`HDKPBL`,`CZKPXE`,`CEZS`,`STATUS`) values (3,'0001','10000001','服务业','服务业','5.00',1,'001',123,'100000.00',1,1),(4,'0001','00000002','餐饮业','餐饮业','5.00',2,'001',5,'100000.00',1,1),(5,'0001','00000003','娱乐业','娱乐业','5.00',3,'001',5,'5.00',1,1),(6,'0001','00000004','休闲业','休闲业','4.00',4,'001',4,'4.00',1,1),(7,'0001','00000005','建筑安装业','建筑安装业','5.00',5,'001',123,'123.00',1,1);

/*Table structure for table `skq_sbczzshjg` */

DROP TABLE IF EXISTS `skq_sbczzshjg`;

CREATE TABLE `skq_sbczzshjg` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `YEAR` int(11) NOT NULL COMMENT '年份',
  `MONTH` int(11) NOT NULL COMMENT '月份',
  `KPSK` decimal(16,2) NOT NULL COMMENT '开票税款',
  `SBSK` decimal(16,2) NOT NULL COMMENT '申报税款',
  `CLBZ` int(11) NOT NULL COMMENT '创建时间',
  `CJSJ` datetime NOT NULL COMMENT '处理标示',
  `CLSJ` datetime DEFAULT NULL COMMENT '处理时间',
  `CLZ` varchar(20) DEFAULT NULL COMMENT '处理者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_sbczzshjg` */

/*Table structure for table `skq_sbhdhjg` */

DROP TABLE IF EXISTS `skq_sbhdhjg`;

CREATE TABLE `skq_sbhdhjg` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `YEAR` int(11) NOT NULL COMMENT '年份',
  `MONTH` int(11) NOT NULL COMMENT '月份',
  `CJSJ` datetime NOT NULL COMMENT '创建时间',
  `CLBZ` int(11) NOT NULL COMMENT '处理标示',
  `CLZ` varchar(20) DEFAULT NULL COMMENT '处理时间',
  `CLSJ` datetime DEFAULT NULL COMMENT '处理者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_sbhdhjg` */

/*Table structure for table `skq_sbsj` */

DROP TABLE IF EXISTS `skq_sbsj`;

CREATE TABLE `skq_sbsj` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `SSKSSJ` date NOT NULL COMMENT '所属开始时间',
  `SSJZSJ` date NOT NULL COMMENT '所属截止时间',
  `ZCPFS` int(11) NOT NULL COMMENT '正常票份数',
  `TPFS` int(11) NOT NULL COMMENT '退票份数',
  `FPFS` int(11) NOT NULL COMMENT '废票份数',
  `ZCPZJE` decimal(16,2) NOT NULL COMMENT '正常票总金额',
  `TPZJE` decimal(16,2) NOT NULL COMMENT '退票总金额',
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `JQBH` varchar(16) NOT NULL COMMENT '机器编号',
  `SBLX` int(11) NOT NULL COMMENT '申报类型',
  `KPJZSJ` datetime DEFAULT NULL COMMENT '开票截止日期',
  `DZKPXE` decimal(16,2) DEFAULT NULL COMMENT '单张开票限额',
  `YLJKPXE` decimal(16,2) DEFAULT NULL COMMENT '月累计开票限额',
  `YLJTPXE` decimal(16,2) DEFAULT NULL COMMENT '月累计退票限额',
  `XZZT` int(11) DEFAULT NULL COMMENT '下载状态',
  `XZRQ` datetime DEFAULT NULL COMMENT '下载日期',
  `CJRQ` datetime DEFAULT NULL COMMENT '创建日期',
  `SBRQ` datetime DEFAULT NULL COMMENT '申报日期',
  `MAC` varchar(20) DEFAULT NULL COMMENT 'MAC',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `skq_sbsj` */

insert  into `skq_sbsj`(`id`,`SSKSSJ`,`SSJZSJ`,`ZCPFS`,`TPFS`,`FPFS`,`ZCPZJE`,`TPZJE`,`NSRWJBM`,`JQBH`,`SBLX`,`KPJZSJ`,`DZKPXE`,`YLJKPXE`,`YLJTPXE`,`XZZT`,`XZRQ`,`CJRQ`,`SBRQ`,`MAC`) values (6,'2015-12-24','2015-12-24',1,0,0,'76.00','0.00','0000000000000001','0000000000000001',2,NULL,'1000010.00','1000010.00','10010.00',1,'2015-12-24 23:01:18','2015-12-24 23:01:18','2015-12-24 22:01:21','B7B367DF'),(8,'2015-12-25','2015-12-25',1,0,0,'1377.00','0.00','0000000000000001','0000000000000001',2,NULL,'1000010.00','1000010.00','10010.00',1,'2015-12-24 23:21:58','2015-12-24 23:21:58','2015-12-24 22:34:21','6AB20463'),(9,'2015-12-26','2015-12-26',0,0,0,'0.00','0.00','0000000000000001','0000000000000001',2,NULL,NULL,NULL,NULL,1,NULL,NULL,'2015-12-24 22:50:40',NULL),(10,'2015-12-27','2015-12-27',1,1,0,'233.00','233.00','0000000000000001','0000000000000001',2,NULL,NULL,NULL,NULL,1,NULL,NULL,'2015-12-24 22:54:49',NULL),(11,'2015-12-28','2015-12-28',0,0,0,'0.00','0.00','0000000000000001','0000000000000001',2,NULL,NULL,NULL,NULL,1,NULL,NULL,'2015-12-24 23:00:33',NULL),(25,'2015-12-29','2015-12-31',0,0,0,'0.00','0.00','0000000000000001','0000000000000001',1,NULL,'1000011.00','1000011.00','10011.00',1,'2015-12-24 23:32:36','2015-12-24 23:32:36','2015-12-24 23:31:06','6AB20463');

/*Table structure for table `skq_sbsjmx` */

DROP TABLE IF EXISTS `skq_sbsjmx`;

CREATE TABLE `skq_sbsjmx` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `PARENTID` int(11) NOT NULL COMMENT '申报数据ID',
  `SMBM` varchar(20) NOT NULL COMMENT '税目编码',
  `JE` decimal(16,2) NOT NULL COMMENT '金额',
  `KPLX` int(11) NOT NULL COMMENT '开票类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `skq_sbsjmx` */

insert  into `skq_sbsjmx`(`id`,`PARENTID`,`SMBM`,`JE`,`KPLX`) values (6,6,'10000001','76.00',1),(11,8,'10000001','123.00',1),(12,8,'00000003','222.00',1),(13,8,'00000004','333.00',1),(14,8,'00000005','699.00',1),(15,10,'00000003','69.00',1),(16,10,'00000004','66.00',1),(17,10,'00000005','98.00',1),(18,10,'00000003','-69.00',2),(19,10,'00000004','-66.00',2),(20,10,'00000005','-98.00',2);

/*Table structure for table `skq_skjs` */

DROP TABLE IF EXISTS `skq_skjs`;

CREATE TABLE `skq_skjs` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `PARENTID` int(11) NOT NULL COMMENT '申报汇总ID',
  `SZBM` varchar(2) NOT NULL COMMENT '税种编码',
  `SMBM` varchar(8) NOT NULL COMMENT '税目编码',
  `JSJE` decimal(16,2) NOT NULL COMMENT '计税金额',
  `SL` decimal(10,4) NOT NULL COMMENT '税率',
  `YJSE` decimal(16,2) NOT NULL COMMENT '应计税额',
  `CLFS` int(11) NOT NULL COMMENT '处理方式',
  `CLBS` int(11) NOT NULL COMMENT '处理标示',
  `SBSJ` datetime DEFAULT NULL COMMENT '申报时间',
  `SBWDH` varchar(20) DEFAULT NULL COMMENT '申报文档号',
  `PBBD` int(11) DEFAULT NULL COMMENT '票表比对',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_skjs` */

/*Table structure for table `skq_wdhxh` */

DROP TABLE IF EXISTS `skq_wdhxh`;

CREATE TABLE `skq_wdhxh` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `WDHXH` int(11) NOT NULL COMMENT '文档号序号',
  `LSXH` int(11) DEFAULT NULL,
  `WJBMXH` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_wdhxh` */

/*Table structure for table `skq_xebg` */

DROP TABLE IF EXISTS `skq_xebg`;

CREATE TABLE `skq_xebg` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NSRWJBM` varchar(20) NOT NULL COMMENT '纳税人微机编码',
  `JQBH` varchar(16) NOT NULL COMMENT '机器编号',
  `SYLJKPXE` decimal(16,2) NOT NULL COMMENT '剩余累计开票限额',
  `SYLJTPXE` decimal(16,2) NOT NULL COMMENT '剩余累计退票限额',
  `SQLJKPXE` decimal(16,2) NOT NULL COMMENT '申请累计开票限额',
  `SQLJTPXE` decimal(16,2) NOT NULL COMMENT '申请累计退票限额',
  `PZLJKPXE` decimal(16,2) DEFAULT NULL COMMENT '申请累计退票限额',
  `PZLJTPXE` decimal(16,2) DEFAULT NULL COMMENT '批准累计退票限额',
  `BGSM` varchar(200) DEFAULT NULL COMMENT '变更说明',
  `SQSJ` datetime NOT NULL COMMENT '申请时间',
  `CLBZ` int(11) NOT NULL COMMENT '处理标示',
  `CLZ` varchar(20) DEFAULT NULL COMMENT '处理者',
  `CLYJ` varchar(200) DEFAULT NULL COMMENT '处理意见',
  `CLSJ` datetime DEFAULT NULL COMMENT '处理时间',
  `XZBS` int(11) DEFAULT NULL COMMENT '下载标示',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `skq_xebg` */

/*Table structure for table `skq_zclx` */

DROP TABLE IF EXISTS `skq_zclx`;

CREATE TABLE `skq_zclx` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ZCLXBM` varchar(20) DEFAULT NULL COMMENT '注册类型编码',
  `ZCLXMC` varchar(100) DEFAULT NULL COMMENT '注册类型名称',
  `ZCLXJC` varchar(50) DEFAULT NULL COMMENT '注册类型简称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `skq_zclx` */

insert  into `skq_zclx`(`id`,`ZCLXBM`,`ZCLXMC`,`ZCLXJC`,`STATUS`) values (1,'00001','个体','个体',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
