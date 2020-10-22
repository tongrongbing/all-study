package com.wenba.studydemo.datastructure.business;

import java.io.Serializable;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/20 2:16 下午
 * @description：
 */
public class ClueData implements Serializable {

    private Integer id;

    private String name;

    public ClueData(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
