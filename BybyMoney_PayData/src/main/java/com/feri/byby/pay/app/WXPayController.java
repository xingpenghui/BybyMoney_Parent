package com.feri.byby.pay.app;

import com.feri.byby.common.constant.SystemCon;
import com.feri.byby.common.util.ResultUtil;
import com.feri.byby.common.vo.ResultBean;
import com.feri.byby.pay.util.WXPaySend;
import com.feri.byby.pay.util.WXPayUtil;
import com.feri.byby.qrcode.QrcodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 *@Author feri
 *@Date Created in 2018/12/11 14:57
 */
@Controller
public class WXPayController {

    private static Map<String,String> orderurl=new LinkedHashMap<>();

    //预下单  请求统一下单接口 获取支付链接
    @PostMapping("wxpaycreate.do")
    @ResponseBody
    public ResultBean create(String name, double price, HttpServletRequest request) throws Exception {
        String oid="zzjava_"+System.currentTimeMillis()+"_"+new Random().nextInt();

        Map<String,String> map=WXPaySend.sendOrderPay(name,price,request.getRemoteAddr(),oid);
        if(Objects.equals(map.get("return_code"),"SUCCESS") && Objects.equals(map.get("result_code"),"SUCCESS")){
            orderurl.put(oid,map.get("code_url"));
            //生成支付信息成功
            return ResultUtil.setOK(oid,null);
        }else {
            return ResultUtil.setError(SystemCon.RERROR1,"微信支付不可用啦",null);
        }
    }
    //生成支付二维码
    @GetMapping("payqrcode.do")
    public void createCode(String oid,HttpServletResponse response) throws IOException {
        System.out.println(orderurl.get(oid));
        QrcodeUtil.createCode(orderurl.get(oid),response.getOutputStream());
    }
    //查询订单状态
    @PostMapping("wxpaychecke.do")
    @ResponseBody
    public ResultBean checkOrder(String oid) throws Exception {
        Map<String,String> map=WXPaySend.checkOrder(oid);
        if(Objects.equals(map.get("return_code"),"SUCCESS")&& Objects.equals(map.get("result_code"),"SUCCESS")){
            return  ResultUtil.setOK(map.get("trade_state"),null);
        }else {
            return ResultUtil.setError(SystemCon.RERROR1,"微信支付不可用啦",null);
        }
    }
    //关闭订单状
    @PostMapping("wxpayclose.do")
    @ResponseBody
    public ResultBean closeOrder(String oid) throws Exception {
        Map<String,String> map=WXPaySend.closeOrder(oid);
        if(Objects.equals(map.get("return_code"),"SUCCESS")&& Objects.equals(map.get("result_code"),"SUCCESS")){
            orderurl.remove(oid);
            return  ResultUtil.setOK(oid+" 订单取消支付",null);
        }else {
            return ResultUtil.setError(SystemCon.RERROR1,"微信支付不可用啦",null);
        }
    }
}