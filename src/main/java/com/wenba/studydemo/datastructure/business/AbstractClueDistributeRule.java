package com.wenba.studydemo.datastructure.business;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/20 1:51 下午
 * @description：
 */
public abstract class AbstractClueDistributeRule implements ClueDistributeRule{

    public abstract void calculate();

    @Override
    public void distribute() {

    }
}
