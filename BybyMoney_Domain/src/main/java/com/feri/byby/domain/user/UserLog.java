package com.feri.byby.domain.user;

import java.util.Date;

public class UserLog {
    private Integer id;

    private Integer uid;

    private String content;
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public UserLog() {
    }

    public UserLog(Integer uid, String content, String ip) {
        this.uid = uid;
        this.content = content;
        this.ip = ip;
    }
}