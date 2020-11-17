package com.wenba.designpattern.observe;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/17 6:00 下午
 * @description： 被观察者事件
 */
public abstract class SubscriptionSubjectEvent {

    public abstract void publishArticle(String articleName);

    public abstract void editArticle(String articleName);

    public abstract void deleteArticle(String articleName);
}
