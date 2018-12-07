package com.feri.byby.common.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2018/12/7 09:30
 */
public class ProTypeBean implements Serializable {
    private int code;
    private List<Map<ProTypeVo,List<ProTypeVo>>> proTypeVos;//一级类型下二级类型

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Map<ProTypeVo, List<ProTypeVo>>> getProTypeVos() {
        return proTypeVos;
    }

    public void setProTypeVos(List<Map<ProTypeVo, List<ProTypeVo>>> proTypeVos) {
        this.proTypeVos = proTypeVos;
    }
}
