package com.fusheng.init.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fusheng.init.common.ErrorCode;
import com.fusheng.init.exception.BusinessException;
import com.fusheng.init.mapper.SysUserMapper;
import com.fusheng.init.model.dto.sysUser.SysUserLoginDTO;
import com.fusheng.init.model.dto.sysUser.SysUserPageQueryDTO;
import com.fusheng.init.model.entity.SysUser;
import com.fusheng.init.model.vo.sysUser.SysUserLoginVO;
import com.fusheng.init.service.SysUserService;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUserLoginVO login(SysUserLoginDTO sysUserLoginDTO) {
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("username", sysUserLoginDTO.getUsername());
        SysUser sysUser = sysUserMapper.selectOne(sysUserQueryWrapper);
        if (sysUser == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        if (!sysUser.getPassword().equals(sysUserLoginDTO.getPassword())) {
            throw new BusinessException(ErrorCode.PASSWORD_ERROR);
        }
        StpUtil.login(sysUser.getId());

        List<JsonElement> list = JsonParser.parseString(sysUser.getRole()).getAsJsonArray().asList();
        List<String> roles = new ArrayList<>();
        for (JsonElement jsonElement : list) {
            roles.add(jsonElement.getAsString());
        }

        SysUserLoginVO sysUserLoginVO = new SysUserLoginVO();
        sysUserLoginVO.setRoles(roles);
        sysUserLoginVO.setUsername(sysUser.getUsername());
        return sysUserLoginVO;
    }

    @Override
    public Page<SysUser> pageQuery(SysUserPageQueryDTO sysUserPageQueryDTO) {
        Page<SysUser> queryPage = new Page<>(sysUserPageQueryDTO.getCurrentPage(), sysUserPageQueryDTO.getPageSize());
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(sysUserPageQueryDTO.getUsername())) {
            queryWrapper.like("username", sysUserPageQueryDTO.getUsername());
        }
        if (StringUtils.isNotBlank(sysUserPageQueryDTO.getPhone())) {
            queryWrapper.like("phone", sysUserPageQueryDTO.getPhone());
        }
        if (StringUtils.isNotBlank(sysUserPageQueryDTO.getUserStatus())) {
            queryWrapper.like("user_status",
                    sysUserPageQueryDTO.getUserStatus().equals("1") ? 1 : 0);
        }
        Page<SysUser> page = sysUserMapper.selectPage(queryPage, queryWrapper);
        //脱敏
        for (SysUser record : page.getRecords()) {
            record.setPassword(null);
        }
        return page;
    }
}
