-- ----------------------------
-- 员工表
-- ----------------------------
-- DROP TABLE IF EXISTS cat_employee;
-- CREATE TABLE cat_employee
-- (
--     id               serial primary key,
--     work_number      varchar(16) NOT NULL,
--     password         varchar(64) NOT NULL,
--     name             varchar(32) NOT NULL,
--     sex              int2,
--     age              int2,
--
--     only_id          int8        NOT NULL,
--     crate_only_id    int8,
--     crate_timestamp  int8,
--     update_only_id   int8,
--     update_timestamp int8,
--     is_deleted       int2        NOT NULL default 0
-- );
-- comment on table cat_employee is '员工表';
-- comment on column cat_employee.id is '主键';
-- comment on column cat_employee.work_number is '工号';
-- comment on column cat_employee.password is '登录密码';
-- comment on column cat_employee.name is '姓名';
-- comment on column cat_employee.sex is '性别[0:女,1:男]';
-- comment on column cat_employee.age is '年龄';
--
-- comment on column cat_employee.only_id is '全局唯一id';
-- comment on column cat_employee.crate_only_id is '创建者(only_id)';
-- comment on column cat_employee.crate_timestamp is '创建时间戳';
-- comment on column cat_employee.update_only_id is '更新者(only_id)';
-- comment on column cat_employee.update_timestamp is '更新时间戳';
-- comment on column cat_employee.is_deleted is '是否已删除[0:未删除,1:已经删除]';

-- ----------------------------
-- 用户表
-- ----------------------------
DROP TABLE IF EXISTS cat_user;
CREATE TABLE cat_user
(
    id               serial primary key,
    username         varchar(64) NOT NULL,
    password         varchar(64) NOT NULL,
    real_name        varchar(32) NOT NULL,
    nick_name        varchar(32) NOT NULL,
    sex              int2,
    age              int2,

    crate_user       int4,
    crate_timestamp  int8,
    update_user      int4,
    update_timestamp int8,
    is_deleted       int2        NOT NULL default 0
);
comment on table cat_user is '用户表';
comment on column cat_user.id is '主键';
comment on column cat_user.username is '登录名';
comment on column cat_user.password is '登录密码';
comment on column cat_user.real_name is '真实姓名';
comment on column cat_user.nick_name is '昵称';
comment on column cat_user.sex is '性别[0:女,1:男]';
comment on column cat_user.age is '年龄';

comment on column cat_user.crate_user is '创建者(user_id)';
comment on column cat_user.crate_timestamp is '创建时间戳';
comment on column cat_user.update_user is '更新者(user_id)';
comment on column cat_user.update_timestamp is '更新时间戳';
comment on column cat_user.is_deleted is '是否已删除[0:未删除,1:已经删除]';

-- ----------------------------
-- 任务表
-- ----------------------------
DROP TABLE IF EXISTS cat_task;
CREATE TABLE cat_task
(
    id               serial primary key,
    title            varchar(64)    NOT NULL,
    digest           varchar(128)   NOT NULL,
    detail           varchar(512)   NOT NULL,
    reward           decimal(10, 4) NOT NULL,
    deadline         int8           NOT NULL,
    target           varchar(64),
    status           int2,

    crate_user       int4,
    crate_timestamp  int8,
    update_user      int4,
    update_timestamp int8,
    is_deleted       int2           NOT NULL default 0
);
comment on table cat_task is '任务表表';
comment on column cat_task.id is '主键';
comment on column cat_task.title is '标题';
comment on column cat_task.digest is '摘要';
comment on column cat_task.detail is '详细内容';
comment on column cat_task.reward is '奖励金额';
comment on column cat_task.deadline is '截止时间';
comment on column cat_task.target is '任务目标';
comment on column cat_task.status is '任务状态[详情见字典表]';

comment on column cat_task.crate_user is '创建者(user_id)';
comment on column cat_task.crate_timestamp is '创建时间戳';
comment on column cat_task.update_user is '更新者(user_id)';
comment on column cat_task.update_timestamp is '更新时间戳';
comment on column cat_task.is_deleted is '是否已删除[0:未删除,1:已经删除]';

-- ----------------------------
-- 用户任务关联关系表
-- ----------------------------
DROP TABLE IF EXISTS cat_user_task;
CREATE TABLE cat_user_task
(
    id               serial primary key,
    user_id          int8 NOT NULL,
    task_id          int8 NOT NULL,

    crate_user       int4,
    crate_timestamp  int8,
    update_user      int4,
    update_timestamp int8,
    is_deleted       int2 NOT NULL default 0
);
comment on table cat_user_task is '任务表表';
comment on column cat_user_task.id is '主键';
comment on column cat_user_task.user_id is '用户id';
comment on column cat_user_task.task_id is '任务id';

comment on column cat_user_task.crate_user is '创建者(user_id)';
comment on column cat_user_task.crate_timestamp is '创建时间戳';
comment on column cat_user_task.update_user is '更新者(user_id)';
comment on column cat_user_task.update_timestamp is '更新时间戳';
comment on column cat_user_task.is_deleted is '是否已删除[0:未删除,1:已经删除]';
