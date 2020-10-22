package com.wenba.studydemo.datastructure.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/20 1:56 下午
 * @description：
 */
public class TMKDistributeBO implements Serializable {

    private Integer ccId;

    private String ccName;

    private Integer dayCapacity;

    private Integer distributedNum = 0;

    public Integer getCcId() {
        return ccId;
    }

    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public Integer getDayCapacity() {
        return dayCapacity;
    }

    public void setDayCapacity(Integer dayCapacity) {
        this.dayCapacity = dayCapacity;
    }

    public Integer getDistributedNum() {
        return distributedNum;
    }

    public void setDistributedNum(Integer distributedNum) {
        this.distributedNum = distributedNum;
    }
}
