package com.feri.byby.app.sso;

import com.feri.byby.common.constant.SystemCon;
import com.feri.byby.common.token.Token;
import com.feri.byby.common.token.TokenUtil;
import com.feri.byby.common.util.CookieUtil;
import com.feri.byby.common.util.EncrypUtil;
import com.feri.byby.common.util.StringUtil;
import com.feri.byby.common.vo.ResultBean;
import com.feri.byby.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Author feri
 *@Date Created in 2018/11/29 14:51
 */
@RestController
public class SSOController {
    @Autowired
    private SSOService ssoService;
    //登录
    @PostMapping("userlogin")
    public ResultBean login(String name, String password, HttpServletRequest request, HttpServletResponse response){
        String token=CookieUtil.getCk(request,SystemCon.TOKECOOKIE);
        if(StringUtil.checkNoEmpty(token)){
            ResultBean rb=ssoService.login(name,password,request.getRemoteAddr());
            if(rb.getCode()==SystemCon.ROK){
                //存储令牌到Cookie
               CookieUtil.setCK(response,SystemCon.TOKECOOKIE,rb.getMsg());
               rb.setMsg("登录成功");
               return rb;
            }else {
                return rb;
            }
        }else{
            //存在Token
            //校验Token
            ResultBean rb= ssoService.checkLogin(token);
            Cookie cookie=new Cookie(SystemCon.TOKECOOKIE,"");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            return rb;
        }
    }
    //检查是否登录
    @GetMapping("userlogincheck")
    public ResultBean check(HttpServletRequest request,HttpServletResponse response){
        String tk=CookieUtil.getCk(request,SystemCon.TOKECOOKIE);
        ResultBean resultBean=ssoService.checkLogin(tk);
        if(resultBean.getCode()!=SystemCon.ROK){
            //存在就刷新时间
            //CookieUtil.setCK(response,SystemCon.TOKECOOKIE,TokenUtil.updateToken(TokenUtil.parseToken(tk)));
            //Token无效 Cookie就需要删除
            Cookie cookie=new Cookie(SystemCon.TOKECOOKIE,"");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return resultBean;
    }
    //注销
    @GetMapping("userloginout")
    public ResultBean loginOut(HttpServletRequest request,HttpServletResponse response){
        ResultBean resultBean=ssoService.loginout(CookieUtil.getCk(request,SystemCon.TOKECOOKIE));
        //Token无效 Cookie就需要删除
        Cookie cookie=new Cookie(SystemCon.TOKECOOKIE,"");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return resultBean;
    }
}
