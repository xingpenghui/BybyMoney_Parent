package com.feri.byby.domain.product;

import java.util.Date;

public class RepSKU {
    private Integer id;

    private Integer repcount;

    public Integer getPsid() {
        return psid;
    }

    public void setPsid(Integer psid) {
        this.psid = psid;
    }

    private Integer psid;

    private Date modtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRepcount() {
        return repcount;
    }

    public void setRepcount(Integer repcount) {
        this.repcount = repcount;
    }

    public Date getModtime() {
        return modtime;
    }

    public void setModtime(Date modtime) {
        this.modtime = modtime;
    }
}