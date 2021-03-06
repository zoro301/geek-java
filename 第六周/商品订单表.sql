CREATE TABLE `t_user` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` VARCHAR(256) NOT NULL DEFAULT '' COMMENT '用户名称',
  `phone` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '联系方式',
  `created_stime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_stime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '是否删除0=正常,1删除',
  PRIMARY KEY (`id`)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
  
  
  CREATE TABLE `t_goods` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `goods_name` VARCHAR(256) NOT NULL DEFAULT '' COMMENT '商品名称',
  `goods_code` VARCHAR(256) NOT NULL DEFAULT '' COMMENT '商品编码',
  `stock` INT (11) NOT NULL DEFAULT 0 COMMENT '商品库存数量',
  `created_stime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_stime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '是否删除0=正常,1删除',
  PRIMARY KEY (`id`)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';
  
CREATE TABLE `t_order` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` INT(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  `created_stime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_stime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '是否删除0=正常,1删除',
  PRIMARY KEY (`id`)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';
  
  CREATE TABLE `t_order_goods` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` INT(11) NOT NULL DEFAULT 0 COMMENT '订单id',
  `goods_id` INT(11) NOT NULL DEFAULT 0 COMMENT '商品id',
  `count` INT (11) NOT NULL DEFAULT 0 COMMENT '商品数量',
  `created_stime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_stime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '是否删除0=正常,1删除',
  PRIMARY KEY (`id`)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='订单商品中奖表';