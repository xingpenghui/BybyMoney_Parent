package com.feri.byby.pay.test;

import com.feri.byby.common.util.HttpUtils;
import com.feri.byby.pay.util.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *@Author feri
 *@Date Created in 2018/12/11 15:18
 */
public class Pay_Test {
    public static void main(String[] args) throws Exception {
        //WXPaySend.sendOrderPay("千锋Java在职升级课程",1,"10.8.162.5");
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid",WXPayConstants.APP_ID);
        data.put("mch_id",WXPayConstants.MCH_ID);
        data.put("body", "郑州Java1805校友卡");
        data.put("out_trade_no", "zzjava_"+System.currentTimeMillis()+"_"+new Random().nextInt());
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "10.8.162.5");
        data.put("notify_url", "http://www.example.com/wxpay/notify");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "12");
        data.put("nonce_str",WXPayUtil.generateNonceStr());
        String sign=WXPayUtil.generateSignature(data,WXPayConstants.API_KEY);
        data.put("sign",sign);
       String request=WXPayUtil.mapToXml(data);
        String response=PayHttpUtil.httpRequest("https://api.mch.weixin.qq.com/pay/unifiedorder",request,2000,2000);
        //System.out.println(response);
        Map<String,String> repMap=WXPayUtil.xmlToMap(response);
        if(WXPayUtil.isSignatureValid(response,WXPayConstants.API_KEY)){
            System.out.println(repMap.get("code_url"));
        }else{
            System.out.println("签名验签失败");
        }
    }
}
