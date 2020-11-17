package com.wenba.designpattern.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/17 5:44 下午
 * @description：
 */
public class SubscriptionSubject extends SubscriptionSubjectEvent implements Observable{

    private List<Observer> weixinUserlist = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer observer) {
        weixinUserlist.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        weixinUserlist.remove(observer);
    }

    @Override
    public void notifyObservers(String context) {
        for (Observer observer : weixinUserlist){
            observer.update(context);
        }
    }

    @Override
    public void publishArticle(String articleName) {
        String content = "小微公众号发布一篇文章：" + articleName;
        this.notifyObservers(content);
    }

    @Override
    public void editArticle(String articleName) {
        String content = "小微公众号编辑一篇文章：" + articleName;
        this.notifyObservers(content);
    }

    @Override
    public void deleteArticle(String articleName) {
        String content = "小微公众号删除一篇文章：" + articleName;
        this.notifyObservers(content);
    }
}
