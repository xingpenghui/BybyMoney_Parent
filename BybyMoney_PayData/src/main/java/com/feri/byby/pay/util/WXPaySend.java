package com.feri.byby.pay.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *@Author feri
 *@Date Created in 2018/12/11 15:04
 */
public class WXPaySend {
    //调用统一下单接口  返回结果
    public static Map<String,String> sendOrderPay(String name,double price,String ip,String orderid) throws Exception {
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid",WXPayConstants.APP_ID);
        data.put("mch_id",WXPayConstants.MCH_ID);
        data.put("body", name);
        data.put("out_trade_no",orderid);
        data.put("fee_type", "CNY");
        //data.put("total_fee", ""+(int)(price*100));//开发版
        data.put("total_fee", "1");//测试版
        data.put("spbill_create_ip", ip);
        data.put("notify_url", "http://www.example.com/wxpay/notify");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("nonce_str",WXPayUtil.generateNonceStr());
        String sign=WXPayUtil.generateSignature(data,WXPayConstants.API_KEY);
        data.put("sign",sign);
        String request=WXPayUtil.mapToXml(data);
        String response=PayHttpUtil.httpRequest("https://api.mch.weixin.qq.com/pay/unifiedorder",request,2000,2000);
        Map<String,String> repMap=WXPayUtil.xmlToMap(response);
       // if(WXPayUtil.isSignatureValid(response,WXPayConstants.API_KEY)){
        return repMap;
       //
        //return resp;
    }
    //查询订单
    public static Map<String,String> checkOrder(String orderid) throws Exception {
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid",WXPayConstants.APP_ID);
        data.put("mch_id",WXPayConstants.MCH_ID);
        data.put("out_trade_no", orderid);
       // data.put("out_trade_no", "zzjava_"+System.currentTimeMillis()+"_"+new Random().nextInt());
        data.put("nonce_str", WXPayUtil.generateNonceStr());
        String sign=WXPayUtil.generateSignature(data,WXPayConstants.API_KEY);
        data.put("sign",sign);
        String request=WXPayUtil.mapToXml(data);
        String response=PayHttpUtil.httpRequest("https://api.mch.weixin.qq.com/pay/orderquery",request,2000,2000);
        Map<String,String> repMap=WXPayUtil.xmlToMap(response);
        return repMap;
    }
    //关闭订单
    public static Map<String,String> closeOrder(String orderid) throws Exception {
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid",WXPayConstants.APP_ID);
        data.put("mch_id",WXPayConstants.MCH_ID);
        data.put("out_trade_no", orderid);
        data.put("nonce_str", WXPayUtil.generateNonceStr());
        String sign=WXPayUtil.generateSignature(data,WXPayConstants.API_KEY);
        data.put("sign",sign);
        String request=WXPayUtil.mapToXml(data);
        String response=PayHttpUtil.httpRequest("https://api.mch.weixin.qq.com/pay/closeorder",request,2000,2000);
        Map<String,String> repMap=WXPayUtil.xmlToMap(response);
        return repMap;
    }
}
