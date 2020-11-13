package com.wenba.thread.firstphase;

import java.util.concurrent.TimeUnit;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/3 3:31 下午
 * @description：
 */
public class DeadLockTest  implements Runnable{

    private static final Object LOCK = new Object();

    private static final Object LOCK2 = new Object();

    public void search(){
        System.out.println(" search");
        synchronized(LOCK){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(LOCK2){
                System.out.println("to do 。。。。。");
            }
        }
    }

    @Override
    public void run() {
        synchronized (LOCK2){
            System.out.println("run lock2");
            synchronized(LOCK){
                System.out.println("run lock1");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockTest deadLockTest = new DeadLockTest();
        Thread thread1 = new Thread(deadLockTest);
        thread1.start();
        deadLockTest.search();
    }
}
