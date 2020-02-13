# rational
##### user表/user_deatil表(后续添加头像属性)

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
	admin_password(13),
	primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

##### 地址表

```mysql
create table address(
    id int(11) not null auto_increment,
    user_id int(11) not null comment '用户id',
    province varchar(15) default null comment '省',
    city varchar(15) default null comment '市',
    county varchar(15) default null comment '县',
    spec_addr varchar(40) default null comment '具体地址',
    primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

##### 商品表

```mysql
--
-- 表的结构 `goods`
--

CREATE TABLE `goods` (
  `goodsId` int(12) NOT NULL auto_increment comment 'goods表主键',
  `goodsName` varchar(50) NOT NULL comment '商品名字',
  `price` float(12) NOT NULL comment '商品价格',
  `num` int(12) NOT NULL comment '商品数量',
  `upTime` datetime NOT NULL comment '商品信息更新时间',
  `category` int(12) NOT NULL comment '所属分类',
  `img_addr` varchar(2000) DEFAULT '' comment '商品图片地址',  
  `description` varchar(2000) NOT NULL comment '商品描述',
  `priority` int(2) NOT NULL DEFAULT '0' comment '商品等级,等级越高越靠前显示',
   `good_status` int(2) not null default '1' comment '商品上下架,1为上架,0为下架',
   primary key (goodsId)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```



##### 店铺表

```mysql
create table store(
    store_id int(11) not null auto_increment comment 'store表主键',
    owner_id int(11) not null comment '逻辑外键店主',
    create_time timestamp NOT NULL comment '店铺创建时间',
    state_code varchar(4) default '1000' comment '店铺状态码 1000有效,1001无效',
    primary key (store_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
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

##### 分类表

```mysql
-- 表的结构 `category`
--

CREATE TABLE `category` (
  `cateId` int(12) NOT NULL auto_increment,
  `cateName` varchar(50) NOT NULL
   `primary` key (cateId)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO `category` (`cateId`, `cateName`) VALUES
(1, '数码'),
(2, '服饰'),
(3, '家电'),
(4, '书籍');
```





##### 订单表

```mysql
--
-- 表的结构 `indent`
--

CREATE TABLE `indent` (
  `orderId` int(12) NOT NULL,
  `userId` int(11) NOT NULL,
  `orderTime` timestamp NOT NULL,
  `price` float NOT NULL,
  `addressId` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```



##### 购物车表

```mysql
--
-- 表的结构 `shopcart`
--

CREATE TABLE `shopcart` (
  `userId` int(12) NOT NULL,
  `goodsid` int(12) NOT NULL,
  `is_order` int(2) DEFAULT NULL comment '下单状态码 1已下单,0未下单',
  `goodsNum` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```



##### 论坛帖子表

```mysql
REATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `creator` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment_count` int(11) DEFAULT '0',
  `view_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  `tag` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```



