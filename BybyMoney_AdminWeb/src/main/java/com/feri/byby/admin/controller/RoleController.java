package com.feri.byby.admin.controller;

import com.feri.byby.admin.domain.Permission;
import com.feri.byby.admin.domain.Role;
import com.feri.byby.admin.service.RoleService;
import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.admin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/11/30 10:21
 */
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    //新增
    @PostMapping("/rolesave.do")
    public R save(Role role){
        return roleService.save(role);
    }
    //查询分页
    @GetMapping("/rolepage.do")
    public PageVo<Role> page(int page, int limit){
        return roleService.queryByPage(page,limit);
    }
    //获取所有角色
    @GetMapping("/roleall.do")
    public List<Role> all(){
        return roleService.queryAll();
    }
    @GetMapping("/roleaid.do")
    public List<Integer> queryByAid(int aid){
        return roleService.selectByAid(aid);
    }
}
