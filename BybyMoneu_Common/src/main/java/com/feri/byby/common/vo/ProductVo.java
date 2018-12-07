package com.feri.byby.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/12/7 15:06
 */
public class ProductVo implements Serializable {
    private int id;
    private String title;
    private double oldprice;
    private double currprice;
    private String url;
    private int orders;
    private List<String> sizes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getOldprice() {
        return oldprice;
    }

    public void setOldprice(double oldprice) {
        this.oldprice = oldprice;
    }

    public double getCurrprice() {
        return currprice;
    }

    public void setCurrprice(double currprice) {
        this.currprice = currprice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }
}
