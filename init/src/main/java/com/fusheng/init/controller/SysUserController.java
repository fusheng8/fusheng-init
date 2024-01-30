package com.fusheng.init.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fusheng.init.common.BaseResponse;
import com.fusheng.init.model.dto.sysUser.SysUserLoginDTO;
import com.fusheng.init.model.dto.sysUser.SysUserPageQueryDTO;
import com.fusheng.init.model.entity.SysUser;
import com.fusheng.init.model.vo.sysUser.SysUserLoginVO;
import com.fusheng.init.model.vo.sysUser.SysUserPageQueryVO;
import com.fusheng.init.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "用户管理")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @Operation(summary = "登录")
    @PostMapping("/login")
    public BaseResponse<SysUserLoginVO> login(@Validated @RequestBody SysUserLoginDTO sysUserLoginDTO) {
        SysUserLoginVO sysUserLoginVO = sysUserService.login(sysUserLoginDTO);
        return BaseResponse.success(sysUserLoginVO);
    }

    @Operation(summary = "获取用户信息")
    @GetMapping("/info")
    public BaseResponse<SysUser> info() {
        long id = StpUtil.getLoginIdAsLong();
        SysUser user = sysUserService.getById(id);
        user.setPassword(null);
        return BaseResponse.success(user);
    }

    @Operation(summary = "查询用户列表")
    @PostMapping("/list")
    public BaseResponse<SysUserPageQueryVO> list(@RequestBody SysUserPageQueryDTO sysUserPageQueryDTO) {
        Page<SysUser> sysUserPage = sysUserService.pageQuery(sysUserPageQueryDTO);
        SysUserPageQueryVO vo = new SysUserPageQueryVO();
        vo.setList(sysUserPage.getRecords());
        vo.setTotal(sysUserPage.getTotal());
        vo.setCurrentPage(sysUserPage.getCurrent());
        vo.setPageSize(sysUserPage.getSize());
        return BaseResponse.success(vo);
    }

    @Operation(summary = "保存用户")
    @PostMapping("/save")
    public BaseResponse<SysUser> save(@RequestBody SysUser sysUser) {
        sysUserService.saveOrUpdate(sysUser);
        return BaseResponse.success(sysUser);
    }

    @Operation(summary = "批量删除用户")
    @GetMapping("/deleteByIds")
    public BaseResponse<Boolean> deleteByIds(@RequestParam List<Long> ids) {
        boolean res = sysUserService.removeBatchByIds(ids);
        return BaseResponse.success(res);
    }
}
