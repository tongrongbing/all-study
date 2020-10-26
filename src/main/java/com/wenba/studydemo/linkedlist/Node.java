package com.wenba.studydemo.linkedlist;

import lombok.Data;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/26 6:53 下午
 * @description：
 */
@Data
public class Node<T> {
    private T data;  // 数据域
    private Node<T> next; // 地址域

    public Node(T data,Node<T> next){
        this.data = data;
        this.next = next;
    }

}
