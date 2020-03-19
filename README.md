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
    store_photo varchar(300) not null comment '店铺头像',
    store_desc varchar(500) comment '店铺简介',
    sotre_cate int(12) not null comment '店铺类别',
    create_time timestamp NOT NULL comment '店铺创建时间',
    state_code varchar(4) default '1001' comment '店铺状态码 1000有效,1001无效 默认无效只有管理员审核才是有效',
    primary key (store_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

##### 商品表

```mysql
--
-- 表的结构 `goods`
--

CREATE TABLE `goods` (
  `good_id` int(11) NOT NULL auto_increment comment 'goods表主键',
  `store_id` int(11) not null,
  `good_name` varchar(50) NOT NULL comment '商品名字',
  `price` float(12) NOT NULL comment '商品价格',
  `num` int(12) NOT NULL comment '商品库存',
  `update_time` datetime NOT NULL comment '商品信息更新时间',
  `category` int(12) NOT NULL comment '所属分类',
  `img_addr` varchar(2000) DEFAULT '' comment '商品图片地址',  
  `description` varchar(2000) NOT NULL comment '商品描述',
  `priority` int(2) NOT NULL DEFAULT '0' comment '商品等级,等级越高越靠前显示',
   `good_status` int(2) not null default '1' comment '商品上下架,1为上架,0为下架',
   primary key (goodsId)
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
    update_time datetime NOT NULL  comment '修改时间',
    primary key (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```


##### 订单表

```mysql
CREATE TABLE `indent` (
  `order_id` int(12) NOT NULL,
  `user_id` int(11) NOT NULL,
  `order_time` timestamp NOT NULL,
  `total_price` float NOT NULL,
  `address_id` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

订单详情表

```mysql
create table indent_detail(
	id int(11) not null  AUTO_INCREMENT  comment '订单详情id',
    user_id int(11) not null  comment '用户id',
    good_id int(11) default null comment '商品id',
    quantity int(11) default 0 comment '数量',
    primary key (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```

