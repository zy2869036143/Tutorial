package com.sdu.supportteach.service;

import com.sdu.supportteach.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzyu
 * @since 2022-01-15
 */
public interface PictureService extends IService<Picture> {
    List<Picture> getAll();

}
