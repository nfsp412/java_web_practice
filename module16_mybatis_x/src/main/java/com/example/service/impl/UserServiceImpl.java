package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author asuka
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-12-09 17:19:18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}




