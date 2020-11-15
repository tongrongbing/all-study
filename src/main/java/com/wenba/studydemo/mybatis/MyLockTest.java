package com.wenba.studydemo.mybatis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/18 10:59
 * @description：
 */
public class MyLockTest {
    public static int num = 0;
    private static MyLock myLock = new MyLock();
    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<Thread>();
        for(int i = 0; i<1;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 1; i<=100;i++){
                        count();
                    }
                }
            });
            list.add(thread);
            thread.start();
        }

       for(int i = 0; i < list.size() ; i++){
            list.get(i).join();
        }
        System.out.println(num);

    }

    public static void count(){
        myLock.lock();
        num++;
        myLock.unlock();
        System.out.println(Thread.currentThread().getName() + " :" + num);
    }
}