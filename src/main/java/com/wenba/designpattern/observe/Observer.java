package com.wenba.designpattern.observe;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/17 1:37 下午
 * @description：观察者
 */
public interface Observer {

    //一发现别人有动静，自己也要行动起来，更新
    public void update(String context);

}
