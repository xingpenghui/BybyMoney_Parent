package com.feri.byby.domain.product;

import java.util.Date;

public class ProPriceSKU {
    private Integer id;

    public Integer getPsid() {
        return psid;
    }

    public void setPsid(Integer psid) {
        this.psid = psid;
    }

    private Integer psid;

    private Integer oldprice;

    private Integer currprice;

    private Date modtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOldprice() {
        return oldprice;
    }

    public void setOldprice(Integer oldprice) {
        this.oldprice = oldprice;
    }

    public Integer getCurrprice() {
        return currprice;
    }

    public void setCurrprice(Integer currprice) {
        this.currprice = currprice;
    }

    public Date getModtime() {
        return modtime;
    }

    public void setModtime(Date modtime) {
        this.modtime = modtime;
    }
}