package com.wenba.studydemo.mybatis;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/18 10:48
 * @description：
 */
public class MyLock {
    private static final Unsafe unsafe;
    private static final long valueOffset;
    static {
        try {
           Class<Unsafe> unsafeClass = Unsafe.class;
            Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            valueOffset = unsafe.objectFieldOffset
                    (MyLock.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }
    private volatile int value = 0;

    public static void main(String[] args) {
        System.out.println(unsafe);
    }

    public void lock(){
        for (;;){
            if(unsafe.compareAndSwapInt(this,valueOffset,0,1)){
                return;
            }
        }
    }

    public void unlock(){
        value = 0;
    }
}