package com.feri.byby.service;

import com.feri.byby.common.vo.ResultBean;

import javax.xml.transform.Result;

/**
 *@Author feri
 *@Date Created in 2018/11/29 10:27
 */
public interface SSOService {
    //登录
    ResultBean login(String name,String password,String ip);
    //检验是否登录
    ResultBean checkLogin(String token);
    //注销
    ResultBean loginout(String token);
}
