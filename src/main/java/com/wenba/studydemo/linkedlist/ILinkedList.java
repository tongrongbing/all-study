package com.wenba.studydemo.linkedlist;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/26 6:42 下午
 * @description：
 */
public interface ILinkedList<T> {
    /**
     * 判断链表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 链表长度
     * @return
     */
    int length();

    /**
     * 获取元素
     * @param index
     * @return
     */
    T get(int index);

    /**
     * 设置某个结点的的值
     * @param index
     * @param data
     * @return
     */
    T set(int index, T data);

    /**
     * 根据index添加结点
     * @param index
     * @param data
     * @return
     */
    boolean add(int index, T data);

    /**
     * 链表头部添加元素
     * @param data
     * @return
     */
    boolean addFirst(T data);

    /**
     * 链表尾部添加元素
     * @param data
     * @return
     */
    boolean addLast(T data);


    /**
     * 根据index移除结点
     * @param index
     * @return
     */
    T remove(int index);

    /**
     * 根据data移除结点
     * @param data
     * @return
     */
    boolean removeAll(T data);

    /**
     * 清空链表
     */
    void clear();

    /**
     * 是否包含data结点
     * @param data
     * @return
     */
    boolean contains(T data);

}
