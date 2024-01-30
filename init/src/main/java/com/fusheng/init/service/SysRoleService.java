package com.fusheng.init.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fusheng.init.model.dto.sysRole.SysRolePageQueryDTO;
import com.fusheng.init.model.entity.SysRole;

public interface SysRoleService extends IService<SysRole> {
    /**
     * 分页查询角色
     * @param sysRolePageQueryDTO
     * @return
     */
    Page<SysRole> pageQuery(SysRolePageQueryDTO sysRolePageQueryDTO);
}
