package com.feri.byby.admin.controller;

import com.feri.byby.admin.service.UserService;
import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *@Author feri
 *@Date Created in 2018/12/3 15:04
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    //查询
    @GetMapping("userpage.do")
    public PageVo<User> page(int page,int limit){
        return userService.queryByPage(page,limit);
    }
}