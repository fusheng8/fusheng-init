package com.fusheng.init.service.impl;

import com.fusheng.init.model.entity.User;
import com.fusheng.init.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {
    @Resource
    UserService userService;

    @Test
    public void main() {
        User user=User.builder()
                .useraccount("admin")
                .username("admin")
                .password("123456")
                .build();
        userService.save(user);
    }
}