package com.sdu.supportteach.service.impl;

import com.sdu.supportteach.entity.Picture;
import com.sdu.supportteach.mapper.PictureMapper;
import com.sdu.supportteach.service.PictureService;
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
 * @since 2022-01-15
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {

    @Autowired
    PictureMapper pictureMapper;
    @Override
    public List<Picture> getAll() {
        return pictureMapper.getAll();
    }
}
