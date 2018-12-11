package com.feri.byby.pay.util;

import java.io.InputStream;

/**
 *@Author feri
 *@Date Created in 2018/12/11 15:05
 */
public class PayConfig extends WXPayConfig {
    private String appID;
    private String mchID;
    private String key;

    public PayConfig() {
        appID=WXPayConstants.APP_ID;
        mchID=WXPayConstants.MCH_ID;
        key=WXPayConstants.API_KEY;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public void setMchID(String mchID) {
        this.mchID = mchID;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    String getAppID() {
        return appID;
    }

    @Override
    String getMchID() {
        return mchID;
    }

    @Override
    String getKey() {
        return key;
    }

    @Override
    InputStream getCertStream() {
        return null;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return null;
    }
}
