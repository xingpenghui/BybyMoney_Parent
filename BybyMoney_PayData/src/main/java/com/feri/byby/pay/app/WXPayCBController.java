package com.feri.byby.pay.app;

import com.feri.byby.pay.util.WXPayUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2018/12/11 15:56
 */
@Controller
public class WXPayCBController {
    @RequestMapping("/wxpaynotify.do")
    public void notify(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //获取回调数据
        String res=IOUtils.toString(request.getInputStream(),"UTF-8");
        Map<String,String> map=WXPayUtil.xmlToMap(res);
        //修改数据库中的订单状态
        //支付状态
        String status=map.get("result_code");
        //支付完成时间
        String wcTime=map.get("time_end");


        Map<String,String> repData=new HashMap<>();
        repData.put("return_code","SUCCESS");
        repData.put("return_msg","OK");
        String repXml=WXPayUtil.mapToXml(repData);
        response.getWriter().print(repXml);
    }
}
