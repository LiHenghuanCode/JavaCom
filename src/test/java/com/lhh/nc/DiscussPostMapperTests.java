package com.lhh.nc;

import com.lhh.nc.entity.DiscussPost;
import com.lhh.nc.mapper.DiscussPostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class DiscussPostMapperTests {
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for(DiscussPost post : list) {
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostTotalPosts(149);
        System.out.println(rows);
    }

    @Test
    public void testInsertDiscussPost() {
        DiscussPost post = new DiscussPost();
        post.setUserId(101);
        post.setTitle("测试标题");
        post.setContent("测试内容，这是一条插入的帖子。");
        post.setType(0);
        post.setStatus(0);
        post.setCreateTime(new Date());
        post.setCommentCount(0);
        post.setScore(0.0);

        int rows = discussPostMapper.insertDiscussPost(post);
        System.out.println("插入行数: " + rows);
        System.out.println("生成的ID: " + post.getId());
    }

}
