CREATE TABLE `t_province` (
`id`  varchar(30) NOT NULL ,
`name`  varchar(30) NULL ,
`search_url_lianjia`  varchar(255) NULL ,
`is_deleted`  bit NULL DEFAULT b'0' ,
`create_time`  datetime NULL DEFAULT NOW() ,
`update_time`  datetime NULL ,
PRIMARY KEY (`id`)
)
;


CREATE TABLE `t_city` (
`id`  varchar(30) NOT NULL ,
`province_id`  varchar(30) NULL ,
`name`  varchar(30) NULL ,
`search_url_lianjia`  varchar(255) NULL ,
`is_deleted`  bit NULL DEFAULT b'0' ,
`create_time`  datetime NULL DEFAULT NOW() ,
`update_time`  datetime NULL ,
PRIMARY KEY (`id`),
INDEX `IN_C_PROVINCE_ID` (`province_id`) USING BTREE
)
;


CREATE TABLE `t_distinct` (
`id`  varchar(30) NOT NULL ,
`province_id`  varchar(30) NULL ,
`city_id`  varchar(30) NULL ,
`name`  varchar(30) NULL ,
`search_url_lianjia`  varchar(255) NULL ,
`is_deleted`  bit NULL DEFAULT b'0' ,
`create_time`  datetime NULL DEFAULT NOW() ,
`update_time`  datetime NULL ,
PRIMARY KEY (`id`),
INDEX `IN_D_PROVINCE_ID` (`province_id`) USING BTREE ,
INDEX `IN_D_CITY_ID` (`city_id`) USING BTREE
)
;

CREATE TABLE `t_province_price` (
`id`  varchar(30) NOT NULL ,
`province_id`  varchar(30) NULL ,
`week`  datetime NULL ,
`month`  datetime NULL ,
`selling_count`  int(8) NULL ,
`selling_avg_price`  int(8) NULL ,
`is_deleted`  bit NULL DEFAULT b'0' ,
`create_time`  datetime NULL DEFAULT NOW() ,
`update_time`  datetime NULL ,
PRIMARY KEY (`id`),
INDEX `IN_PP_PROVINCE_ID` (`province_id`) USING BTREE
)
;

CREATE TABLE `t_city_price` (
`id`  varchar(30) NOT NULL ,
`province_id`  varchar(30) NULL ,
`city_id`  varchar(30) NULL ,
`load_day`  datetime NULL ,
`week`  datetime NULL ,
`month`  datetime NULL ,
`selling_count`  int(8) NULL ,
`selling_avg_price`  int(8) NULL ,
`is_deleted`  bit(1) NULL DEFAULT b'0' ,
`create_time`  datetime NULL DEFAULT NOW() ,
`update_time`  datetime NULL ,
PRIMARY KEY (`id`),
INDEX `IN_CP_PROVINCE_ID` (`province_id`) USING BTREE ,
INDEX `IN_CP_CITY_ID` (`city_id`) USING BTREE
)
;

CREATE TABLE `t_distinct_price` (
`id`  varchar(30) NOT NULL ,
`province_id`  varchar(30) NULL ,
`city_id`  varchar(30) NULL ,
`distinct_id`  varchar(30) NULL ,
`load_day`  datetime NULL ,
`week`  datetime NULL ,
`month`  datetime NULL ,
`selling_count`  int(8) NULL ,
`selling_avg_price`  int(8) NULL ,
`is_deleted`  bit(1) NULL DEFAULT b'0' ,
`create_time`  datetime NULL DEFAULT NOW() ,
`update_time`  datetime NULL ,
PRIMARY KEY (`id`),
INDEX `IN_CP_PROVINCE_ID` (`province_id`) USING BTREE ,
INDEX `IN_CP_CITY_ID` (`city_id`) USING BTREE ,
INDEX `IN_CP_DISTINCT_ID` (`distinct_id`) USING BTREE
)
;

CREATE TABLE `t_generate_log` (
`id`  varchar(30) NOT NULL ,
`type`  varchar(30) NULL ,
`load_day`  varchar(10) NULL ,
`is_deleted`  bit(1) NULL DEFAULT b'0' ,
`create_time`  datetime NULL DEFAULT NOW() ,
`update_time`  datetime NULL ,
PRIMARY KEY (`id`),
INDEX `IN_GL_LOAD_DAY` (`load_day`) USING BTREE
)
;

