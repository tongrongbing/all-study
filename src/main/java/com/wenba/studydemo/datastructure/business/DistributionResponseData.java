package com.wenba.studydemo.datastructure.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/20 4:04 下午
 * @description：
 */
public class DistributionResponseData implements Serializable {
    private Integer ccId;
    private String ccName;
    private List<ClueData> clueDataList = new ArrayList<>();

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

    public List<ClueData> getClueDataList() {
        return clueDataList;
    }

    public void setClueDataList(List<ClueData> clueDataList) {
        this.clueDataList = clueDataList;
    }
}
