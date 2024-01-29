package com.fusheng.init.controller;

import com.fusheng.init.common.BaseResponse;
import com.fusheng.init.model.dto.user.AddUserDTO;
import com.fusheng.init.model.entity.User;
import com.fusheng.init.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@Tag(name = "用户管理")
public class UserController {
    @Resource
    private UserService userService;

    @Operation(summary = "保存用户")
    @PostMapping("/save")
    public BaseResponse save(@RequestBody AddUserDTO addUserDTO) {
        User user = new User();
        BeanUtils.copyProperties(addUserDTO, user);
        userService.save(user);
        return BaseResponse.success("保存成功");
    }

}
