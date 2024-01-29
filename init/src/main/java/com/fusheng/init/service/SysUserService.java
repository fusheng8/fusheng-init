package com.fusheng.init.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fusheng.init.model.dto.sysUser.SysUserLoginDTO;
import com.fusheng.init.model.entity.SysUser;

public interface SysUserService extends IService<SysUser> {
    /**
     * 登录用户
     *
     * @param sysUserLoginDTO
     */
    void login(SysUserLoginDTO sysUserLoginDTO);
}