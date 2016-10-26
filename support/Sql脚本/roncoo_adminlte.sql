#
# 龙果开源-后台管理系统
#

#
# Structure for table "rc_data_dictionary"
#

CREATE TABLE `rc_data_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `field_name` varchar(255) NOT NULL COMMENT '字段名',
  `field_code` varchar(255) NOT NULL COMMENT '字段CODE',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='数据字典';

#
# Structure for table "rc_data_dictionary_list"
#

CREATE TABLE `rc_data_dictionary_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `field_code` varchar(255) NOT NULL COMMENT '字段CODE',
  `field_key` varchar(255) NOT NULL COMMENT '字段KEY',
  `field_value` varchar(255) NOT NULL COMMENT '字段VALUE',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '字段排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='数据字典明细表';

#
# Structure for table "rc_email_account_info"
#

CREATE TABLE `rc_email_account_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `from_user` varchar(255) NOT NULL COMMENT '发件人',
  `passwd` varchar(255) NOT NULL COMMENT '密码',
  `host` varchar(255) NOT NULL COMMENT 'HOST',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='邮件发送账号信息表';

#
# Structure for table "rc_email_info"
#

CREATE TABLE `rc_email_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `to_user` char(18) DEFAULT NULL,
  `from_user` char(21) DEFAULT NULL,
  `title` varchar(225) DEFAULT NULL,
  `subject` varchar(225) DEFAULT NULL,
  `content` varchar(5120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='邮件信息表';

#
# Structure for table "rc_user_login_logs"
#

CREATE TABLE `rc_user_login_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `roncoo_no` varchar(255) NOT NULL COMMENT '龙果账号',
  `login_ip` varchar(255) NOT NULL COMMENT '登录IP',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录信息记录表';
