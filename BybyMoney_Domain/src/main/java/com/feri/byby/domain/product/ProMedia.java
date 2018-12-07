package com.feri.byby.domain.product;

import java.util.Date;

public class ProMedia {
    private Integer id;

    private Integer pid;

    private Integer flag;

    private Date createtime;

    private String presurl;

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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getPresurl() {
        return presurl;
    }

    public void setPresurl(String presurl) {
        this.presurl = presurl == null ? null : presurl.trim();
    }
}