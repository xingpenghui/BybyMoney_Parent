package com.feri.byby.domain.product;

public class ProductDetail {
    private Integer id;

    private Integer pid;
    private String detail;

    private String commonsku;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getCommonsku() {
        return commonsku;
    }

    public void setCommonsku(String commonsku) {
        this.commonsku = commonsku == null ? null : commonsku.trim();
    }

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
}