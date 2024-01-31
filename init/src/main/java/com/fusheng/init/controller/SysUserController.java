package com.fusheng.init.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fusheng.init.common.BaseResponse;
import com.fusheng.init.common.ErrorCode;
import com.fusheng.init.exception.BusinessException;
import com.fusheng.init.mapper.SysUserMapper;
import com.fusheng.init.model.dto.sysUser.SetUserRoleDTO;
import com.fusheng.init.model.dto.sysUser.SysUserLoginDTO;
import com.fusheng.init.model.dto.sysUser.SysUserPageQueryDTO;
import com.fusheng.init.model.entity.SysUser;
import com.fusheng.init.model.vo.sysUser.SysUserLoginVO;
import com.fusheng.init.model.vo.sysUser.SysUserPageQueryVO;
import com.fusheng.init.service.SysUserService;
import com.fusheng.init.utils.PasswordUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "用户管理")
@SaCheckLogin
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @SaIgnore
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
        SysUser user = sysUserService.getUserInfoById(id);

        return BaseResponse.success(user);
    }

    @SaCheckRole("admin")
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
        //权限校验 非管理员只能修改自己的信息
        if (!StpUtil.hasRole("admin")&&
                (sysUser.getId()!=null&&sysUser.getId() != StpUtil.getLoginIdAsLong())) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        if (StringUtils.isNoneEmpty(sysUser.getPassword())) {
            //密码加密
            String password = PasswordUtil.encrypt(sysUser.getPassword());
            sysUser.setPassword(password);
        }
        sysUserService.saveOrUpdate(sysUser);
        return BaseResponse.success(sysUser);
    }

    @SaCheckRole("admin")
    @Operation(summary = "批量删除用户")
    @GetMapping("/deleteByIds")
    public BaseResponse<Boolean> deleteByIds(@RequestParam List<Long> ids) {
        boolean res = sysUserService.removeBatchByIds(ids);
        return BaseResponse.success(res);
    }

    @SaCheckRole("admin")
    @Operation(summary = "根据用户id查找对应的角色id列表")
    @GetMapping("/getRoleIdsByUserId")
    public BaseResponse<String> getRoleIdsByUserId(@RequestParam Long userId) {
        SysUser user = sysUserService.getById(userId);
        if (user == null) throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        return BaseResponse.success(user.getRole());
    }

    @SaCheckRole("admin")
    @Operation(summary = "设置用户角色")
    @PostMapping("/setUserRole")
    public BaseResponse setUserRole(@RequestBody SetUserRoleDTO setUserRoleDTO) {
        sysUserService.setUserRole(setUserRoleDTO);
        return BaseResponse.success();
    }

}
