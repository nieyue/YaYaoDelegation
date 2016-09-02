# 数据库 
#创建数据库
DROP DATABASE IF EXISTS yayaodelegation_db;
CREATE DATABASE yayaodelegation_db;

#使用数据库 
use yayaodelegation_db;
#创建用户表 
CREATE TABLE user_tb(
user_id int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
nice_name varchar(255) COMMENT '昵称',
name varchar(255) COMMENT '账户名',
password varchar(255) COMMENT '密码',
openid varchar(255) COMMENT '微信openid',
reg_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
last_login_time timestamp  DEFAULT CURRENT_TIMESTAMP COMMENT '最后登陆时间',
PRIMARY KEY (user_id),
INDEX idx_openid (openid) USING BTREE,
INDEX idx_reg_time (reg_time) USING BTREE,
INDEX idx_last_login_time (last_login_time) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';

#创建团长表 
CREATE TABLE mer_group_tb(
mer_group_id int(11) NOT NULL AUTO_INCREMENT COMMENT '商品团长id',
open_num int(11) COMMENT '开团次数',
join_num int(11) COMMENT '参团人数(总，只算成团人数)',
success_num int(11) COMMENT '已经成团次数',
faile_num int(11) COMMENT '已经拼团失败次数',
performance decimal(10,2) COMMENT '业绩',
commission decimal(10,2) COMMENT '获得佣金',
free_num int(11) COMMENT '免单次数',
user_id int(11) COMMENT '用户id',
PRIMARY KEY (mer_group_id),
CONSTRAINT FK_USER_MERGROUP FOREIGN KEY (user_id) REFERENCES user_tb (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX idx_user_id (user_id) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='团长表';

#创建商户表 
CREATE TABLE seller_tb(
seller_id int(11) NOT NULL AUTO_INCREMENT COMMENT '商户id',
seller_email varchar(255) COMMENT '邮箱',
seller_phone varchar(255) COMMENT '手机',
seller_password varchar(255) COMMENT '登录密码',
seller_nice_name varchar(255) COMMENT '店铺昵称',
seller_img varchar(255) COMMENT '店铺图片',
seller_number int(11) COMMENT '店铺收藏数',
is_signature varchar(255) COMMENT '店铺介绍',
is_authentication tinyint(11) COMMENT '是否企业认证商户默认为0，未认证',
register_date timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
authentication_date timestamp NULL COMMENT '认证时间',
appid varchar(255) COMMENT 'appid',
secret varchar(255) COMMENT 'secret',
PRIMARY KEY (seller_id),
INDEX idx_register_date (register_date) USING BTREE,
INDEX idx_authentication_date (authentication_date) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商户表';

#创建商品类型表 
CREATE TABLE mer_cate_tb(
mer_cate_id int(11) NOT NULL AUTO_INCREMENT COMMENT '商品类型id',
name varchar(255) COMMENT '商品类型名称',
update_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
seller_id int(11) COMMENT '商户id,外键',
PRIMARY KEY (mer_cate_id),
CONSTRAINT FK_SELLER_MERCATE FOREIGN KEY (seller_id) REFERENCES seller_tb (seller_id) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX idx_seller_id (seller_id) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品类型表';

#创建商品表 
CREATE TABLE mer_tb(
mer_id int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
mer_thumb_img varchar(255) COMMENT '商品缩略图',
mer_title varchar(255) COMMENT '商品名称',
mer_old_price decimal(10,2) COMMENT '原始价格',
mer_price decimal(10,2) COMMENT '销售价格',
mer_stock int(11) COMMENT '库存',
mer_code varchar(255) COMMENT '商品编码',
mer_discount decimal(10,2) DEFAULT 1.00 COMMENT '折扣',
mer_postage decimal(10,2) DEFAULT 0.00 COMMENT '包邮',
mer_update_time timestamp  DEFAULT CURRENT_TIMESTAMP COMMENT '商品更新时间',
mer_status tinyint(4) DEFAULT 1 COMMENT '上架1，下架0',
mer_cate_id int(11) COMMENT '商品类型id,外键',
seller_id int(11) COMMENT '商户id,外键',
mer_img_identify varchar(255) COMMENT '商品图片标识',
PRIMARY KEY (mer_id),
CONSTRAINT FK_SELLER_MER FOREIGN KEY (seller_id) REFERENCES seller_tb (seller_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_MERCATE_MER FOREIGN KEY (mer_cate_id) REFERENCES mer_cate_tb (mer_cate_id) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX idx_mer_cate_id (mer_cate_id) USING BTREE,
INDEX idx_seller_id (seller_id) USING BTREE,
INDEX idx_mer_update_time (mer_update_time) USING BTREE,
INDEX idx_mer_img_identify (mer_img_identify) USING BTREE,
INDEX idx_mer_status (mer_status) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品表';

#创建商品图片表 
CREATE TABLE mer_img_tb(
mer_img_id int(11) NOT NULL AUTO_INCREMENT COMMENT '商品图片id',
mer_img_address varchar(255) COMMENT '商品图地址',
mer_img_update_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '商品图片更新时间',
order_num int(11) COMMENT '排序数字',
mer_id int(11) COMMENT '商品id,外键',
seller_id int(11) COMMENT '商户id,外键',
PRIMARY KEY (mer_img_id),
CONSTRAINT FK_MER_MERIMG FOREIGN KEY (mer_id) REFERENCES mer_tb (mer_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_SELLER_MERIMG FOREIGN KEY (seller_id) REFERENCES seller_tb (seller_id) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX idx_mer_id (mer_id) USING BTREE,
INDEX idx_order_num (order_num) USING BTREE,
INDEX idx_seller_id (seller_id) USING BTREE,
INDEX idx_mer_img_update_time (mer_img_update_time) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品图片表';

#创建收货地址表 
CREATE TABLE receipt_address_tb(
receipt_address_id int(11) NOT NULL AUTO_INCREMENT COMMENT '收货地址id',
receipt_address_name varchar(255) COMMENT '收货地址姓名',
receipt_address_phone varchar(255) COMMENT '收货地址手机号',
receipt_address_site varchar(255) COMMENT '收货地址',
receipt_address_update_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '收货地址更新时间',
is_default tinyint(4) DEFAULT 0 COMMENT '默认为0不是，1是',
user_id int(11) COMMENT '用户id,外键',
PRIMARY KEY (receipt_address_id),
CONSTRAINT FK_USER_RECEIPTADDRESS FOREIGN KEY (user_id) REFERENCES user_tb (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX idx_user_id (user_id) USING BTREE,
INDEX idx_is_default (is_default) USING BTREE,
INDEX idx_receipt_address_update_time (receipt_address_update_time) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='收货地址表 ';

#创建拼团配置表
CREATE TABLE group_pugin_tb(
group_pugin_id int(11) NOT NULL AUTO_INCREMENT COMMENT '拼团配置id',
mer_group_discount decimal(10,2) COMMENT '拼团折扣',
mer_group_price decimal(10,2) COMMENT '拼团价格',
open_person int(11) COMMENT '开团人数',
group_discount tinyint(4) COMMENT '团长佣金比例',
group_commission decimal(10,2) COMMENT '团长佣金',
is_free tinyint(4) COMMENT '是否免单0,不免， 1,免单',
mer_id int(11) COMMENT '商品id,外键',
PRIMARY KEY (group_pugin_id),
CONSTRAINT FK_MER_GROUPPUGIN FOREIGN KEY (mer_id) REFERENCES mer_tb (mer_id) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX idx_mer_id (mer_id) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='拼团配置表';

#创建拼团表
CREATE TABLE fight_group_tb(
fight_group_id int(11) NOT NULL AUTO_INCREMENT COMMENT '拼团id',
open_person int(11) COMMENT '开团人数',
join_person int(11) COMMENT '已参团人数',
mer_group_discount tinyint(4) COMMENT '团长佣金比例',
mer_group_commission decimal(10,2) COMMENT '团长佣金',
is_free tinyint(4) COMMENT '是否免单0,不免， 1,免单',
open_group_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '开团时间',
is_success tinyint(4) COMMENT '是否成功 0,失败， 1,成功',
mer_id int(11) COMMENT '商品id,外键',
mer_group_id int(11) COMMENT '拼团队长id,外键',
PRIMARY KEY (fight_group_id),
CONSTRAINT FK_MER_FIGHTGROUP FOREIGN KEY (mer_id) REFERENCES mer_tb (mer_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_MERGROUP_FIGHTGROUP FOREIGN KEY (mer_group_id) REFERENCES mer_group_tb (mer_group_id) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX idx_mer_id (mer_id) USING BTREE,
INDEX idx_mer_group_id (mer_group_id) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='拼团表';
