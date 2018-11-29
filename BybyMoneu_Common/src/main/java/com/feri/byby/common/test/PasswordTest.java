package com.feri.byby.common.test;

import com.feri.byby.common.constant.SystemCon;
import com.feri.byby.common.util.EncrypUtil;

/**
 *@Author feri
 *@Date Created in 2018/11/29 14:11
 */
public class PasswordTest {
    public static void main(String[] args) {
        String key=EncrypUtil.createAesKey();
        System.out.println(key);
        String res="HelloWord";
        //加密
        String es=EncrypUtil.encAesStr(SystemCon.TOKENKEY,res);
        System.out.println("1加密："+es);
        //解密
        System.out.println("1解密："+EncrypUtil.decAesStr(SystemCon.TOKENKEY,es));
        //加密
        String es2=EncrypUtil.encAesStr(SystemCon.PASSKEY,res);
        System.out.println("2加密："+es2);
        //解密
        System.out.println("2解密："+EncrypUtil.decAesStr(SystemCon.PASSKEY,es2));
    }
}
