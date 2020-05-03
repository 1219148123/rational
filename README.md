##### user表/user_deatil表

```mysql
create table user(
	user_id int(11) not null auto_increment comment 'use表主键',
    user_account varchar(20) not null comment '用户账号',
    user_password varchar(20) not null comment '用户密码',
    state_code varchar(4) default '1000' comment '用户状态码 1000有效,1001无效',
    primary key (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

```mysql
create table user_detail(
	id int(11) not null auto_increment comment '用户细节表主键id',
    user_id int(11) not null comment '用户id',
    user_name varchar(20) default null comment '用户姓名',
    sex varchar(2) default null comment '用户性别',
    user_email varchar(20) default null comment '用户邮箱',
    user_phone varchar(18) default null comment '用户电话',
    user_address_id int(11) default  null comment '用户地址可以有多个用,隔开',
    user_plan_spent double(8,2) default 0 comment '用户每月计划消费数额',
    user_current_spent double(8,2) default 0 comment '用户当前消费数额',
    user_create_time timestamp default CURRENT_TIMESTAMP comment '用户创建时间',
    open_store int(2) default 0 comment '是否开店,0为没有,1为店主',
    primary key (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;  
```

##### admin表

```mysql
create table admin(
	id int(11) not null auto_increment,
	admin_account varchar(13),
	admin_password(13) varchar(20),
	primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

##### 地址表

```mysql
create table address(
    id int(11) not null auto_increment,
    user_id int(11) not null comment '下单用户id',
    province varchar(15) default null comment '省',
    city varchar(15) default null comment '市',
    county varchar(15) default null comment '县',
    spec_addr varchar(40) default null comment '具体地址',
    consignee varchar(20) not null comment '收获人姓名',
    phone varchar(18) not null comment'联系电话',
    primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```



##### 店铺表

```mysql
create table store(
    store_id int(11) not null auto_increment comment 'store表主键',
    owner_id int(11) not null comment '逻辑外键店主',
    store_name varchar(250) not null comment '店铺名字',
    store_photo varchar(300) default null comment '店铺头像',
    store_desc varchar(500) comment '店铺简介',
    sotre_cate int(12) not null comment '店铺类别',
    create_time timestamp NOT NULL comment '店铺创建时间',
    state_code varchar(4) default '1001' comment '店铺状态码 1000有效,1001无效 默认无效只有管理员审核才是有效',
    primary key (store_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

##### 商品表

```mysql
CREATE TABLE `goods` (
  `good_id` int(11) NOT NULL auto_increment comment 'goods表主键',
  `store_id` int(11) not null,
  `good_name` varchar(50) NOT NULL comment '商品名字',
  `price` double(8,2) NOT NULL comment '商品价格',
  `num` int(12) NOT NULL comment '商品库存',
  `update_time` datetime NOT NULL comment '商品信息更新时间',
  `category` int(12) NOT NULL comment '所属分类',
  `img_addr` varchar(2000) DEFAULT '' comment '商品图片地址',  
  `description` varchar(2000) NOT NULL comment '商品描述',
  `priority` int(2) NOT NULL DEFAULT '0' comment '商品等级,等级越高越靠前显示',
   `good_status` int(2) not null default '1' comment '商品上下架,1为上架,0为下架',
   primary key (good_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

##### 购物车表

```mysql
create table cart(
	id int(11) not null  AUTO_INCREMENT,
    user_id int(11) not null,
    good_id int(11) default null comment '商品id',
    quantity int(11) default 0 comment '数量',
    checked int(11) default 0 comment'是否选择，1=已勾选，0=未勾选',
    create_time datetime NOT NULL  comment '创建时间',
    update_time datetime default NULL  comment '修改时间',
    primary key (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```

##### 订单表

```mysql
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL  AUTO_INCREMENT  comment '订单id',
  `user_id` int(11) NOT NULL,
  `order_time` datetime NOT NULL,
  `total_price` decimal(8,2) NOT NULL,
  `address_id` int(12) NOT NULL,
  `order_status` int(11) default 0 comment'是否结账，1=已结账，0=未结账',
     PRIMARY KEY (order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

订单详情表

```mysql
create table order_detail(
	id int(11) not null  AUTO_INCREMENT  comment '订单详情id',
     `order_id` int(11) NOT NULL comment '订单id',
    good_id int(11) default null comment '商品id',
    quantity int(11) default 0 comment '数量',
    `price` double(8,2) NOT NULL comment '商品价格',
    `total_price` decimal(8,2) NOT NULL,
    primary key (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```



##### 分类表

```mysql
-- 表的结构 `category`
--

CREATE TABLE `category` (
  `cate_id` int(12) NOT NULL auto_increment,
  `cate_name` varchar(50) NOT NULL,
   primary key (cateId)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO `category` (`cate_id`, `cateName`) VALUES
(1, '数码'),
(2, '服饰'),
(3, '家电'),
(4, '书籍');
```





##### 店铺商品关系表

```mysql
create table store_user_rel(
    id int(11) not null auto_increment comment 'store_user_rel表主键'
    store_id int(11) not null comment 'store表主键',
    goodsId int(12) not null comment '商品标识符',
    create_time timestamp NOT NULL comment '商品添加时间',
    state_code varchar(4) default '1000' comment '商品状态码 1000有效,1001无效',
    primary key (store_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```





##### 论坛帖子表

```mysql
CREATE TABLE `discuss` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'discuss表主键',
  title VARCHAR(50) NOT NULL COMMENT '帖子标题',
  description  VARCHAR(256) NOT NULL COMMENT '帖子内容',
  tag VARCHAR(256) NOT NULL COMMENT '帖子标签',
  author INT(11) NOT NULL COMMENT '作者id',  
  gmt_create  DATETIME NOT NULL COMMENT '帖子发表时间',
  gmt_modified  DATETIME DEFAULT NULL COMMENT '帖子修改时间',
  like_count INT DEFAULT 0 COMMENT '帖子点赞数',
  comment_count INT DEFAULT 0 COMMENT '帖子评论数',
  view_count INT DEFAULT 0 COMMENT '帖子观看数',
  state_code VARCHAR(4) DEFAULT '1000' COMMENT '状态码 1000有效,1001无效',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```





##### 论坛帖子评论表

```mysql
CREATE TABLE `comment` (
 `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'comment表主键',
  parent_id int(11) not null comment '父类帖子或者父类评论Id',
  type int(2) not null comment '评论类型1为文章评论2为评论的评论',
  content varchar(256) not null comment '评论的内容',
  commentator int(11) not null comment '评论人id',
  create_time  DATETIME NOT NULL COMMENT  '评论发表时间',
  like_count int default 0 comment '评论点赞数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```



