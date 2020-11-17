package com.wenba.designpattern.observe;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/17 5:43 下午
 * @description：
 */
public class WeixinUser implements Observer{

    private String username;

    public WeixinUser(String username){
        this.username = username;
    }
    @Override
    public void update(String context) {
        System.out.println(username + "接收到一条消息：" + context);
    }
}
