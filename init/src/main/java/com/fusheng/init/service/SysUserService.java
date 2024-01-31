package com.fusheng.init.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fusheng.init.model.dto.sysUser.SetUserRoleDTO;
import com.fusheng.init.model.dto.sysUser.SysUserLoginDTO;
import com.fusheng.init.model.dto.sysUser.SysUserPageQueryDTO;
import com.fusheng.init.model.entity.SysUser;
import com.fusheng.init.model.vo.sysUser.SysUserLoginVO;

public interface SysUserService extends IService<SysUser> {
    /**
     * 登录用户
     *
     * @param sysUserLoginDTO
     */
    SysUserLoginVO login(SysUserLoginDTO sysUserLoginDTO);

    /**
     * 分页查询用户
     *
     * @param sysUserPageQueryDTO
     * @return
     */
    Page<SysUser> pageQuery(SysUserPageQueryDTO sysUserPageQueryDTO);

    /**
     * 设置用户角色
     *
     * @param setUserRoleDTO
     */
    void setUserRole(SetUserRoleDTO setUserRoleDTO);

    /***
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    SysUser getUserInfoById(long id);
}