package com.fusheng.init.model.dto.sysUser;

import com.fusheng.init.model.common.PageQueryDTO;
import lombok.Builder;
import lombok.Data;

/**
 * 分页查询用户
 */
@Data
public class SysUserPageQueryDTO extends PageQueryDTO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 状态
     */
    private String userStatus;
    /**
     * 手机号
     */
    private String phone;

}
