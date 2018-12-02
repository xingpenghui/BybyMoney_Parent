package com.feri.byby.es.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 *@Author feri
 *@Date Created in 2018/12/2 16:13
 * 基于es存储
 */
@Document(indexName = "projects",type = "JavaProject")
public class JavaProject implements Serializable {
    private int id;
    //DeprecationHandler dh;
    private String name;
    private double money;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
