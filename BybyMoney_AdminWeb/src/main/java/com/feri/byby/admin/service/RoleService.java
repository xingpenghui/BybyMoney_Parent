package com.feri.byby.admin.service;

import com.feri.byby.admin.domain.Role;
import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.admin.vo.R;

import java.util.List;


/**
 *@Author feri
 *@Date Created in 2018/11/30 10:16
 */
public interface RoleService {
    //新增角色
    R save(Role role);
    //更新角色权限
    R updatePermission(int[] pids, int rid);
    //分页查询
    PageVo<Role> queryByPage(int page,int limit);
    //所有角色
    List<Role> queryAll();
    //获取某个用户的所有角色
    List<Integer> selectByAid(int aid);
}
