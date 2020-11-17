package com.wenba.designpattern.observe;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/17 5:46 下午
 * @description：
 */
public class ObserverClient {
    public static void main(String[] args) throws Exception{
        //创建微信用户
        WeixinUser user1 = new WeixinUser("杨影枫");
        WeixinUser user2 = new WeixinUser("月眉儿");
        WeixinUser user3 = new WeixinUser("紫轩");

        //创建公众号
        SubscriptionSubject mSubscriptionSubject = new SubscriptionSubject();
        mSubscriptionSubject.addObserver(user1);
        mSubscriptionSubject.addObserver(user2);
        mSubscriptionSubject.addObserver(user3);

        mSubscriptionSubject.publishArticle("Java 设计模式美");
        System.out.println();
        Thread.sleep(1000);
        mSubscriptionSubject.editArticle("Java 设计模式美");
        System.out.println();
        Thread.sleep(1000);
        mSubscriptionSubject.deleteArticle("Java 设计模式美");
    }




}
