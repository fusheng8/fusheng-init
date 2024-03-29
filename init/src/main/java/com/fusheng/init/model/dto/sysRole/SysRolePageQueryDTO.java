package com.fusheng.init.model.dto.sysRole;

import com.fusheng.init.model.common.PageQueryDTO;
import lombok.Builder;
import lombok.Data;

/**
 * 分页查询角色
 */
@Data
public class SysRolePageQueryDTO extends PageQueryDTO {
    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色权限字符串
     */
    private String roleKey;

    /**
     * 角色状态（1正常 0停用）
     */
    private String status;

}
