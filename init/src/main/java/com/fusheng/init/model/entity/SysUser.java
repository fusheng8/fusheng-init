package com.fusheng.init.model.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户表
 */
@Data
@TableName(value = "sys_user")
public class SysUser {
    /**
    * 主键
    */
    @TableId(type = IdType.AUTO)
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
    private String role;

    /**
    * 状态
    */
    private int userStatus;

    /**
    * 是否删除(0-未删, 1-已删)
    */
    @TableLogic
    private Byte isDeleted;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 创建者
    */
    private Long createBy;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新者
    */
    private Long updateBy;
}