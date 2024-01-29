package com.fusheng.init.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;

/**
 * 用户表
 */
@Data
@TableName(value = "user")
public class User implements Serializable {
    /**
    * 主键
    */
    @TableId(type = IdType.AUTO)
    private Long id;

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

    /**
    * 更新时间
    */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
    * 创建时间
    */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
    * 是否删除(0-未删, 1-已删)
    */
    @TableLogic
    private Byte isDeleted;
}