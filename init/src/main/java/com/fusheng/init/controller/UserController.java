package com.fusheng.init.controller;

import cn.dev33.satoken.util.SaResult;
import com.fusheng.init.common.BaseResponse;
import com.fusheng.init.model.dto.sysUser.SysUserLoginDTO;
import com.fusheng.init.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "用户管理")
public class UserController {
    @Resource
    private SysUserService sysUserService;

    @Operation(summary = "登录")
    @PostMapping("/login")
    public BaseResponse login(@Validated @RequestBody SysUserLoginDTO sysUserLoginDTO) {
        sysUserService.login(sysUserLoginDTO);
        return BaseResponse.success("登录成功");
    }

}
