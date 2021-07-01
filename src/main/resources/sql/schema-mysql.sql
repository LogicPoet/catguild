-- 用户表
CREATE TABLE IF NOT EXISTS `cat_user`
(
    `id`         BIGINT UNSIGNED AUTO_INCREMENT COMMENT '主键',
    `username`   VARCHAR(128) NOT NULL COMMENT '登录名',
    `password`   VARCHAR(128) NOT NULL COMMENT '登录密码',
    `real_name`  VARCHAR(128) NOT NULL COMMENT '真实姓名',
    `nick_name`  VARCHAR(128) NOT NULL COMMENT '昵称',
    `sex`   SMALLINT   COMMENT '性别',
    `age`   SMALLINT   COMMENT '年龄',

    `status` SMALLINT  DEFAULT 0 COMMENT '状态',
    `create_time` BIGINT  NOT NULL COMMENT '创建日期',
    `create_user` BIGINT  NOT NULL COMMENT '创建人',
    `update_time` BIGINT  NOT NULL COMMENT '更新日期',
    `update_user` BIGINT  NOT NULL COMMENT '更新人',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
-- 添加索引（登录名）
ALTER TABLE `cat_user` ADD INDEX `idx_username` (username);

-- 委托表
CREATE TABLE IF NOT EXISTS `cat_delegation`
(
    `id`       BIGINT UNSIGNED AUTO_INCREMENT,
    `title`    VARCHAR(128) NOT NULL COMMENT '标题',
    `type`     SMALLINT  NOT NULL COMMENT '类型',
    `digest`   VARCHAR(256)  NOT NULL COMMENT '摘要',
    `content`  VARCHAR(1000) NOT NULL COMMENT '委托内容',
    `reward`   VARCHAR(256)  NOT NULL COMMENT '报酬内容',
    `target`   VARCHAR(256)  NOT NULL COMMENT '任务目标',
    `deadline` BIGINT  NOT NULL COMMENT '最后期限',

    `status` SMALLINT  NOT NULL COMMENT '状态',
    `create_time` BIGINT  NOT NULL COMMENT '创建日期',
    `create_user` BIGINT  NOT NULL COMMENT '创建人',
    `update_time` BIGINT  NOT NULL COMMENT '更新日期',
    `update_user` BIGINT  NOT NULL COMMENT '更新人',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='委托表';
-- 添加索引（标题）
ALTER TABLE `cat_delegation` ADD INDEX `idx_title` (title);

CREATE TABLE IF NOT EXISTS `cat_user_delegation`
(
    `id`         BIGINT UNSIGNED AUTO_INCREMENT COMMENT '主键',
    `user_id`    BIGINT NOT NULL COMMENT '用户id',
    `delegation_id`  BIGINT NOT NULL COMMENT '委托id',

    `status` SMALLINT  DEFAULT 0 COMMENT '状态',
    `create_time` BIGINT  NOT NULL COMMENT '创建日期',
    `create_user` BIGINT  NOT NULL COMMENT '创建人',
    `update_time` BIGINT  NOT NULL COMMENT '更新日期',
    `update_user` BIGINT  NOT NULL COMMENT '更新人',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户接取委托表';
-- 添加索引（登录名）
ALTER TABLE `cat_user_delegation` ADD INDEX `idx_user_id_delegation_id` (user_id,delegation_id);
