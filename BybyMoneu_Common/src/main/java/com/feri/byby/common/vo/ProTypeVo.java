package com.feri.byby.common.vo;

import java.io.Serializable;

/**
 *@Author feri
 *@Date Created in 2018/12/7 09:32
 */
public class ProTypeVo implements Serializable {
    private int id;
    private String name;

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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ProTypeVo){
            ProTypeVo vo=(ProTypeVo)obj;
            return this.getId()==vo.getId();
        }else {
            return false;
        }
    }
}
