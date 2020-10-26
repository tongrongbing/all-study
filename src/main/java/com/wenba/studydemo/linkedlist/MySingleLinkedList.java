package com.wenba.studydemo.linkedlist;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/26 6:52 下午
 * @description：
 */
public class MySingleLinkedList<T> implements ILinkedList<T>{
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T data) {
        return null;
    }

    /**
     * @author: tongrongbing
     * @description:
     *
     * 根据下标添加结点
     *      * 1.头部插入
     *      * 2.中间插入
     *      * 3.末尾插入
     *
     *
     * @time: 2020/10/26 6:56 下午
     * @param index     下标索引  下标值从0开始
     * @param data       添加 数据
     * @return boolean
     */
    @Override
    public boolean add(int index, T data) {
        if(data == null){
            return false;
        }


        return false;
    }

    @Override
    public boolean add(T data) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean removeAll(T data) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T data) {
        return false;
    }
}
