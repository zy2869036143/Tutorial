package com.sdu.supportteach.service.impl;

import com.sdu.supportteach.entity.Blog;
import com.sdu.supportteach.mapper.BlogMapper;
import com.sdu.supportteach.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzyu
 * @since 2022-01-13
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<Blog> getByUserId(int id) {
        return blogMapper.getBlogByUserId(id);
    }

    @Override
    public List<Blog> getByType(int type) {
        return blogMapper.getByType(type);
    }
}
