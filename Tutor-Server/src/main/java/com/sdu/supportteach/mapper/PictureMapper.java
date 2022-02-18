package com.sdu.supportteach.mapper;

import com.sdu.supportteach.entity.Picture;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzyu
 * @since 2022-01-15
 */
@Mapper
public interface PictureMapper extends BaseMapper<Picture> {
    List<Picture> getAll();
}
