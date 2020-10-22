package com.wenba.studydemo.datastructure.business;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/20 1:53 下午
 * @description：
 */
public class TMKClueDistributeRule extends AbstractClueDistributeRule{
    private static final List<TMKDistributeBO> boList = new ArrayList<TMKDistributeBO>();
    private static final List<ClueData> clueList = new ArrayList<ClueData>();
    // 初始化三个CC和线索量
    static {
        initCCData();
        initClueData();
    }

    @Override
    public void calculate() {
        int numSize = boList.size();
        for(int i = 0 ;i < clueList.size() ;i++){
            TMKDistributeBO tmkDistributeBO = boList.get(i % numSize);
            Integer distributedNum = tmkDistributeBO.getDistributedNum();
            Integer dayCapacity = tmkDistributeBO.getDayCapacity();
            if(distributedNum >= dayCapacity){
                continue;
            }
            distributedNum++;
            tmkDistributeBO.setDistributedNum(distributedNum);
        }
    }

    public static void main(String[] args) {
        TMKClueDistributeRule tmkClueDistributeRule = new TMKClueDistributeRule();
        tmkClueDistributeRule.calculate();
        System.out.println("======================");
        TMKDistributeBO bo4 = new TMKDistributeBO();
        bo4.setCcId(400);
        bo4.setDayCapacity(15);
        bo4.setCcName("cc4号");
        boList.add(bo4);
        tmkClueDistributeRule.calculate();
        System.out.println("========end===========");
    }

    private static void initCCData(){
        TMKDistributeBO bo1 = new TMKDistributeBO();
        bo1.setCcId(100);
        bo1.setDayCapacity(10);
        bo1.setCcName("cc1号");
        boList.add(bo1);
        TMKDistributeBO bo2 = new TMKDistributeBO();
        bo2.setCcId(200);
        bo2.setDayCapacity(10);
        bo2.setCcName("cc2号");
        boList.add(bo2);
        TMKDistributeBO bo3 = new TMKDistributeBO();
        bo3.setCcId(300);
        bo3.setDayCapacity(7);
        bo3.setCcName("cc3号");
        boList.add(bo3);
    }

    private static void initClueData(){
        for(int i = 0 ; i < 20 ; i++){
            ClueData data = new ClueData(i,"线索"+i+"号");
            clueList.add(data);
        }
    }
}
