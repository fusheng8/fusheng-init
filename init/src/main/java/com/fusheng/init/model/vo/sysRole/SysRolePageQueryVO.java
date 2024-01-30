package com.fusheng.init.model.vo.sysRole;

import com.fusheng.init.model.common.PageQueryVO;
import com.fusheng.init.model.entity.SysRole;
import com.fusheng.init.model.entity.SysUser;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 分页查询用户
 */
@Data
public class SysRolePageQueryVO extends PageQueryVO {
    /**
     * 查询列表
     */
    private List<SysRole> list;


}
