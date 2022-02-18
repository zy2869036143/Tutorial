package com.sdu.supportteach.service;

import com.sdu.supportteach.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzyu
 * @since 2022-01-13
 */
public interface BlogService extends IService<Blog> {
    List<Blog> getByUserId(int id);
    List<Blog> getByType(int type);
}
