package com.fusheng.init.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fusheng.init.common.BaseResponse;
import com.fusheng.init.model.dto.sysRole.SysRolePageQueryDTO;
import com.fusheng.init.model.dto.sysUser.SysUserLoginDTO;
import com.fusheng.init.model.dto.sysUser.SysUserPageQueryDTO;
import com.fusheng.init.model.entity.SysRole;
import com.fusheng.init.model.entity.SysUser;
import com.fusheng.init.model.vo.sysRole.SysRolePageQueryVO;
import com.fusheng.init.model.vo.sysUser.SysUserPageQueryVO;
import com.fusheng.init.service.SysRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Tag(name = "角色管理")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @Operation(summary = "登录")
    @GetMapping("/list-all-role")
    public BaseResponse<List<SysRole>> getAllRole() {
        return BaseResponse.success(sysRoleService.list());
    }

    @Operation(summary = "查询角色列表")
    @PostMapping("/list")
    public BaseResponse<SysRolePageQueryVO> list(@RequestBody SysRolePageQueryDTO sysRolePageQueryDTO) {
        Page<SysRole> sysUserPage = sysRoleService.pageQuery(sysRolePageQueryDTO);
        SysRolePageQueryVO vo = new SysRolePageQueryVO();
        vo.setList(sysUserPage.getRecords());
        vo.setTotal(sysUserPage.getTotal());
        vo.setCurrentPage(sysUserPage.getCurrent());
        vo.setPageSize(sysUserPage.getSize());
        return BaseResponse.success(vo);
    }

}
