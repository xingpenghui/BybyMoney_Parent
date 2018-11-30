package com.feri.byby.admin.common;

import com.feri.byby.admin.vo.R;

/**
 *@Author feri
 *@Date Created in 2018/11/30 11:45
 */
public class RUtil {
    //
    public static R setOK(String msg){
        return new R(200,msg,null);
    }
    public static R setERROR(String msg){
        return new R(400,msg,null);
    }
    public static R setRes(int count){
        if(count>0){
            return setOK("操作成功");
        }else {
            return setERROR("操作失败");
        }
    }
}
