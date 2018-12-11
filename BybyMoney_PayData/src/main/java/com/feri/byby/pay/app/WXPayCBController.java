package com.feri.byby.pay.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Author feri
 *@Date Created in 2018/12/11 15:56
 */
@Controller
public class WXPayCBController {
    @RequestMapping("/wxpaynotify.do")
    public void notify(HttpServletRequest request,HttpServletResponse response){

    }
}
