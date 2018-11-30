package com.feri.byby.admin.controller;

import com.feri.byby.admin.domain.Permission;
import com.feri.byby.admin.service.PermissionService;
import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.admin.vo.R;
import com.feri.byby.common.vo.PageBean;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/11/30 10:21
 */
@RestController
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    //新增
    @PostMapping("/permissionsave.do")
    public R save(Permission permission){
        return permissionService.save(permission);
    }
    //查询
    @GetMapping("/permissionpage.do")
    public PageVo<Permission> page(int page,int limit){
        return permissionService.queryByPage(page,limit);
    }
    //查询一级菜单
    @RequestMapping("/permissionmenu.do")
    public List<Permission> rootmenu(){
        return permissionService.queryFirstMenu();
    }




}
