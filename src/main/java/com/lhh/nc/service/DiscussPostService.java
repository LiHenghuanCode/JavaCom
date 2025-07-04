package com.lhh.nc.service;

import com.lhh.nc.entity.DiscussPost;
import com.lhh.nc.mapper.DiscussPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostTotalPosts(int userId) {
        return discussPostMapper.selectDiscussPostTotalPosts(userId);
    }
}
