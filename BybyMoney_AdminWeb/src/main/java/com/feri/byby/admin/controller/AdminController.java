package com.feri.byby.admin.controller;

import com.feri.byby.admin.common.RUtil;
import com.feri.byby.admin.domain.Admin;
import com.feri.byby.admin.service.AdminService;
import com.feri.byby.admin.vo.MenuVo;
import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.admin.vo.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/11/30 10:20
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    //登录
    @PostMapping("/adminlogin.do")
    public R login(String rm, String name, String password, HttpServletRequest request){
        Admin admin=adminService.login(name,password);
        if(admin!=null){
            //登录成功
            //通知Shiro登录成功
            Subject subject=SecurityUtils.getSubject();
            UsernamePasswordToken token=new UsernamePasswordToken(name,password);
            if(rm!=null && rm.length()>0) {
                token.setRememberMe(true);
            }
            System.out.println("登录："+admin.getId());
            subject.getSession().setAttribute("admin",admin);
            subject.login(token);
            return RUtil.setOK("登录成功");
        }else {
            return RUtil.setERROR("用户名或密码错误");
        }
    }
    //新增用户
    @PostMapping("/adminsave.do")
    public R save(Admin admin){
        return adminService.save(admin);
    }
    //验证是否存在用户名 存在返回1 不存在返回0
    @RequestMapping("/admincheck.do")
    public R check(String name) throws IOException {
        return adminService.checkName(name);
    }
    //查询 分页
    @RequestMapping("/adminpage.do")
    public PageVo<Admin> list(int page, int limit){
        return adminService.queryByPage(page,limit);
    }

    //修改用户角色
    @RequestMapping("/adminroleedit.do")
    public R edit(int[] rid,HttpServletResponse response) throws IOException {
        Admin user=(Admin)SecurityUtils.getSubject().getSession().getAttribute("admin");
        return adminService.updateRole(rid,user.getId());
    }
    //注销
    @GetMapping("/adminloginout.do")
    public void loginout(HttpServletResponse response) throws IOException {
        SecurityUtils.getSubject().getSession().removeAttribute("admin");
        response.sendRedirect("login.html");
    }
    //查询左菜单
    @GetMapping("/adminmenus.do")
    public List<MenuVo> menus(){
        Admin admin= (Admin) SecurityUtils.getSubject().getSession().getAttribute("admin");
        return adminService.queryMenu(admin.getId());
    }
}