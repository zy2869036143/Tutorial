package com.sdu.supportteach.mapper;

import com.sdu.supportteach.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzyu
 * @since 2022-01-13
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
    List<Blog> getBlogByUserId(int user_id);
    List<Blog> getByType(int type);
}
