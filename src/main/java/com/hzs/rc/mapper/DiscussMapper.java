package com.hzs.rc.mapper;

import com.hzs.rc.entity.Discuss;
import com.hzs.rc.vo.DiscussVO;

import java.util.List;

public interface DiscussMapper {
    //1.发表帖子
    int insert(Discuss discuss);

    //2.修改帖子
    void update(Discuss discuss);
    //3.删除帖子
    int delete(Integer id);
    //4.帖子详情查看
    DiscussVO selectDiscuss(Integer id);
    //5.查询所有帖子列表 按热度排序 同时查出作者信息
    List<DiscussVO> discussMng();
    //6.修改查看数 +1

    //7.修改评论数+1

    //8.修改点赞数+1

    //9.修改更新时间
    void  updateTime(Discuss discuss);
}