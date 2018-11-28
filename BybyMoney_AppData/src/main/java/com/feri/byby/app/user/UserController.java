package com.feri.byby.app.user;

import com.feri.byby.common.vo.ResultBean;
import com.feri.byby.domain.user.User;
import com.feri.byby.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *@Author feri
 *@Date Created in 2018/11/28 11:31
 */
@Api(value = "操作用户的数据接口")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    //新增
    @ApiOperation(value = "用户注册",httpMethod = "POST",notes = "实现用户注册功能")
    @PostMapping("useradd.do")
    public ResultBean save( User user, HttpServletRequest request)
    {
        return userService.save(user,request.getRemoteAddr());
    }
    //重置密码
    @ApiOperation(value = "密码重置",httpMethod = "POST",notes = "实现用户的密码修改")
    @PostMapping("userpass.do")
    public ResultBean updatePass(int uid,String password,HttpServletRequest request){
        return userService.updatePass(uid,password,request.getRemoteAddr());
    }
    //校验昵称或手机号是否存在
    @ApiOperation(value = "校验昵称或手机号是否可以",notes = "可用返回OK")
    @GetMapping("usercheck.do")
    public ResultBean checkName(@ApiParam(value = "name需要校验的内容，可以是昵称，也可以是手机号") String name){
        return userService.checkRepeat(name);
    }
}
