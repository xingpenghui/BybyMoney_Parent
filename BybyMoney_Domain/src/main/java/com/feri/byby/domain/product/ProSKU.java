package com.feri.byby.domain.product;

import java.util.Date;

public class ProSKU {
    private Integer id;

    private Integer pid;

    private String pskujson;

    private Date modtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPskujson() {
        return pskujson;
    }

    public void setPskujson(String pskujson) {
        this.pskujson = pskujson == null ? null : pskujson.trim();
    }

    public Date getModtime() {
        return modtime;
    }

    public void setModtime(Date modtime) {
        this.modtime = modtime;
    }
}