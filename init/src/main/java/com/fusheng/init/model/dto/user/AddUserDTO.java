package com.fusheng.init.model.dto.user;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 */
@Data
@Builder
public class AddUserDTO implements Serializable {

    /**
     * 用户账号
     */
    private String useraccount;

    /**
    * 头像
    */
    private String avatar;

    /**
    * 密码
    */
    private String password;

    /**
    * 用户昵称
    */
    private String username;

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
    private String role;

    /**
    * 状态
    */
    private String userStatus;

}