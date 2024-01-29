package com.fusheng.init.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fusheng.init.mapper.UserMapper;
import com.fusheng.init.model.entity.User;
import com.fusheng.init.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
