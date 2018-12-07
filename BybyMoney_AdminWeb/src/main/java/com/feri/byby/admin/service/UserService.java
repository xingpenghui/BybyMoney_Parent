package com.feri.byby.admin.service;

import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.domain.user.User;

/**
 *@Author feri
 *@Date Created in 2018/12/3 14:50
 */
public interface UserService {
    PageVo<User> queryByPage(int page,int limit);
}
