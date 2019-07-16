CREATE TABLE `t_user` (
  `id`       bigint(20)  NOT NULL,
  `name`     varchar(50) NOT NULL
  COMMENT '用户名',
  `password` varchar(20) NOT NULL
  COMMENT '密码',
  PRIMARY KEY (`id`),
  KEY        `key_name` (`name`) USING BTREE
) ENGINE =InnoDB DEFAULT CHARSET = utf8;