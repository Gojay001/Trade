#删除数据库
DROP DATABASE IF EXISTS trade;

#创建数据库
CREATE DATABASE trade;

#选择数据库
USE trade;

#创建用户表
CREATE TABLE `user` (
 	`id` INTEGER(11) NOT NULL AUTO_INCREMENT,
 	`username` VARCHAR(11) NOT NULL COMMENT '用户名',
	`nickname` VARCHAR(22) NOT NULL COMMENT '用户昵称',
  	`password` VARCHAR(22) NOT NULL COMMENT '用户密码',
  	`tel` VARCHAR(11) NOT NULL COMMENT '用户电话',
	`qq` VARCHAR(11) NOT NULL COMMENT '用户QQ',
	`email` VARCHAR(22) NOT NULL COMMENT '用户邮箱',
	`address` VARCHAR(255) NOT NULL COMMENT '用户地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#创建商品表
CREATE TABLE `goods` (
  	`id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  	`name` VARCHAR(22) NOT NULL COMMENT '商品名称',
  	`price` DECIMAL DEFAULT 0 COMMENT '商品价格',
	`catagory` VARCHAR(22) DEFAULT NULL COMMENT '商品类别',
	`detail` TEXT NOT NULL COMMENT '商品图片',
	`create_time` DATE NOT NULL COMMENT '创建时间',
	`sell_id` INTEGER(11) DEFAULT NULL COMMENT '卖家id',
	`buy_id` INTEGER(11) DEFAULT NULL COMMENT '买家id',
	`status` INT DEFAULT 1 COMMENT '交易状态',
	`view` INT DEFAULT 0 COMMENT '商品访问量',
  	PRIMARY KEY (`id`),
	FOREIGN KEY(sell_id) REFERENCES user(id),
	FOREIGN KEY(buy_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#创建收藏表
CREATE TABLE `collection` (
  	`id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  	`user_id` INTEGER(11) NOT NULL COMMENT '用户编号',
	`goods_id` INTEGER(11) NOT NULL COMMENT '商品编号',
  	PRIMARY KEY (`id`),
  	FOREIGN KEY(user_id) REFERENCES user(id),
	FOREIGN KEY(goods_id) REFERENCES goods(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#创建商品图片表
CREATE TABLE `image` (
  	`id` INTEGER(11) NOT NULL AUTO_INCREMENT,
	`goods_id` INTEGER(11) NOT NULL COMMENT '商品编号',
	`name` VARCHAR(255) NOT NULL COMMENT '商品图片',
  	PRIMARY KEY (`id`),
	FOREIGN KEY(goods_id) REFERENCES goods(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
