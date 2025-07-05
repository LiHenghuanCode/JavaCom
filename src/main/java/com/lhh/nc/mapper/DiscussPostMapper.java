package com.lhh.nc.mapper;

import com.lhh.nc.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    /**
     * 目的：根据用户id查找帖子，帖子数量为limit，从第offset个帖子开始返回
     * @param userId
     * @param offset
     * @param limit
     * @return
     */

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     * 目的：查找用户发布的帖子总数
     * @param userId
     * @return
     */
    int selectDiscussPostTotalPosts(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

}
