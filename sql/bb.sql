/*
SQLyog Professional v13.1.1 (64 bit)
MySQL - 5.7.32-log : Database - bb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bb`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成员id',
  `member_account` varchar(12) NOT NULL COMMENT '成员账号',
  `member_name` varchar(12) NOT NULL DEFAULT 'who am i' COMMENT '成员姓名',
  `password` varchar(40) NOT NULL COMMENT '密码',
  `salt` varchar(40) NOT NULL COMMENT '盐',
  `member_status` int(11) DEFAULT '0' COMMENT '0,正常;1,锁定;2,禁用;3,删除',
  PRIMARY KEY (`member_id`),
  UNIQUE KEY `member_account` (`member_account`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`member_id`,`member_account`,`member_name`,`password`,`salt`,`member_status`) values
(1,'yufei','余飞','38f291b54f4776a1170d3af6df37ddd0','bb6f79a742a54425949d89a73daff280',0);

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '科目编号',
  `course_name` varchar(60) DEFAULT NULL COMMENT '科目名称',
  `specialty_id` int(11) DEFAULT NULL COMMENT '所属专业编号',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

/*Table structure for table `dict_data` */

DROP TABLE IF EXISTS `dict_data`;

CREATE TABLE `dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典数据表';

/*Data for the table `dict_data` */

/*Table structure for table `dict_type` */

DROP TABLE IF EXISTS `dict_type`;

CREATE TABLE `dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典类型表';

/*Data for the table `dict_type` */

/*Table structure for table `member_role` */

DROP TABLE IF EXISTS `member_role`;

CREATE TABLE `member_role` (
  `member_id` int(11) NOT NULL COMMENT '成员ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member_role` */

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` int(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（C目录 M菜单 B按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT '' COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

/*Data for the table `menu` */

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `qu_name` varchar(32) NOT NULL DEFAULT '' COMMENT '题目名',
  `qu_number` varchar(32) NOT NULL DEFAULT '' COMMENT '题目编号',
  `qu_level` tinyint(4) NOT NULL DEFAULT '1' COMMENT '题目难度等级',
  `qu_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '题型类型',
  `score` double NOT NULL DEFAULT '0' COMMENT '分值',
  `course_id` int(11) NOT NULL COMMENT '科目ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_by` int(11) NOT NULL DEFAULT '0' COMMENT '创建者ID',
  `update_by` int(11) NOT NULL DEFAULT '0' COMMENT '修改者ID',
  `remark` varchar(60) NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='题目表';

/*Data for the table `question` */

insert  into `question`(`id`,`qu_name`,`qu_number`,`qu_level`,`qu_type`,`score`,`course_id`,`create_time`,`update_time`,`create_by`,`update_by`,`remark`,`deleted`) values
(1,'Q:给别人他也会让他','2565701d3f504cddabca13e73f12a03c',1,3,2,1,'2020-12-02 15:28:06','2020-12-02 15:28:06',0,0,'',0),
(2,'Q:发动机和特定语境同意','7181996710f44287be59c73f45f3e370',1,3,2,1,'2020-12-02 15:28:06','2020-12-02 15:28:06',0,0,'',0),
(3,'Q:更多挥金如土用热水','273f735e8a0348af983cc58b17a4c2fb',1,3,2,1,'2020-12-02 15:28:06','2020-12-02 15:28:06',0,0,'',0),
(4,'Q:就如同也是也让也容易','5ad4c4c1639e4de3aa89e19dde5686c6',1,3,2,1,'2020-12-02 15:28:06','2020-12-02 15:28:06',0,0,'',0),
(5,'Q:发原图的投入颐和园太热','12656607783244918d5e3cf366087e62',1,3,2,1,'2020-12-02 15:28:06','2020-12-02 15:28:06',0,0,'',0),
(6,'Q:国家的try热一热晒太阳','ad8bb0292faa49268ae5928baa0937b0',1,3,2,1,'2020-12-02 15:28:06','2020-12-02 15:28:06',0,0,'',0),
(27,'Q:法国就很容易很多人提交合同','699729500ae248cf98b3ecdab01acbdf',1,1,2,1,'2020-12-02 15:30:21','2020-12-02 15:30:21',0,0,'',0),
(28,'Q:风格和健康认识他也如同','df36fb4c90684a038399be31c6d22fc6',1,1,2,1,'2020-12-02 15:30:21','2020-12-02 15:30:21',0,0,'',0),
(29,'Q:今天又的加入也让通过','7ca6074a15714d368ef877ae4a93ebfe',1,1,2,1,'2020-12-02 15:30:21','2020-12-02 15:30:21',0,0,'',0),
(30,'Q:警方固然是同样特人与','8cd828744bbb4e4995286cd0350e64a1',1,1,2,1,'2020-12-02 15:30:21','2020-12-02 15:30:21',0,0,'',0),
(31,'Q:地方各级官府孩子的法国队','bec4d088db704d6da79dc5388fb3c73e',1,1,2,1,'2020-12-02 15:30:21','2020-12-02 15:30:21',0,0,'',0),
(32,'Q:过后就是让他未提供的合法化','b548720a99954b5c8f0640894bf736dd',1,1,2,1,'2020-12-02 15:30:21','2020-12-02 15:30:21',0,0,'',0),
(33,'Q:更多挥金如土也会让人他','dafcdd4ff6a14dc09e54f4961b69c449',1,1,2,1,'2020-12-02 15:30:21','2020-12-02 15:30:21',0,0,'',0);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色Id',
  `role_name` varchar(12) NOT NULL COMMENT '角色名称',
  `role_key` varchar(8) DEFAULT NULL COMMENT '角色权限',
  `parent_role_id` int(11) DEFAULT NULL COMMENT '父角色Id',
  `role_sort` varchar(8) DEFAULT NULL COMMENT '角色排序',
  `role_status` int(11) DEFAULT '0' COMMENT '角色状态',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
