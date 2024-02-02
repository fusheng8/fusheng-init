package com.fusheng.init.model.vo.sysUser;


import lombok.Data;

import java.util.List;

@Data
public class SysUserInfoVO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 角色
     */
    private List<String> roles;

    /**
     * 状态
     */
    private Byte userStatus;

}
