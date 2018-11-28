package com.feri.byby.service;

import com.feri.byby.common.vo.ResultBean;
import com.feri.byby.domain.user.User;

/**
 *@Author feri
 *@Date Created in 2018/11/28 13:46
 */
public interface UserService {
    //新增用户
    ResultBean save(User user,String ip);
    //修改密码
    ResultBean updatePass(int uid,String password,String ip);
    //校验昵称或手机号是否重复
    ResultBean checkRepeat(String name);
}
