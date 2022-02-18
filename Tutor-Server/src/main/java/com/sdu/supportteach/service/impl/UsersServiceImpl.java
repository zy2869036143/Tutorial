package com.sdu.supportteach.service.impl;

import com.sdu.supportteach.entity.Users;
import com.sdu.supportteach.mapper.UsersMapper;
import com.sdu.supportteach.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzyu
 * @since 2022-01-10
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
