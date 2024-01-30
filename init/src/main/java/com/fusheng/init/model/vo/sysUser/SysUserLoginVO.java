package com.fusheng.init.model.vo.sysUser;

import lombok.Data;

import java.util.List;

@Data
public class SysUserLoginVO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 角色
     */
    private List<String> roles;
}
