package com.feri.byby.admin.service;

import com.feri.byby.admin.domain.Permission;
import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.admin.vo.R;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/11/30 10:16
 */
public interface PermissionService {
    //新增权限
    R save(Permission permission);
    //查询用户的权限
    List<String> queryByAid(int aid);
    //分页
    PageVo<Permission> queryByPage(int page, int limit);
    //查询一级菜单
    List<Permission> queryFirstMenu();
}
