package com.wenba.studydemo.linkedlist;
/**
 * @author：tongrongbing
 * @date：created in 2020/10/26 6:52 下午
 * @description：     自定义链表
 */
public class MySingleLinkedList<T> implements ILinkedList<T>{

    private Node<T> head; // 头节点

    private int size;

    public MySingleLinkedList(){
    }

    private static class Node<T>{
        private T data;  // 数据域
        private Node<T> next; // 地址域

        public Node(T data,Node<T> next){
            this.data = data;
            this.next = next;
        }

        public Node(T data){
            this(data,null);
        }
    }

    /**
     * @author: tongrongbing
     * @description:            往头部添加元素，添加之前头部 head != null的
     * @time: 2020/10/27 10:45 上午
     * @param data
     * @return boolean
     */
    @Override
    public boolean addFirst(T data) {
        Node<T> node = new Node<T>(data);
        node.next = this.head;
        head = node;
        size++;
        return true;
    }

    /**
     * @author: tongrongbing
     * @description:           在链表的尾部添加元素
     * @time: 2020/10/27 2:30 下午
     * @param data
     * @return boolean
     */
    @Override
    public boolean addLast(T data) {
        Node<T> front = this.head;
        for (int i = 0; i < length() - 1; i++) {
            front = front.next;
        }
        front.next = new Node<T>(data,null);
        size++;
        return true;
    }

    /**
     * @author: tongrongbing
     * @description:
     *
     * 向链表中间添加元素
     * @time: 2020/10/26 6:56 下午
     *          index是从0开始计算，也就是说传递的index=3时，插入的是链表中第4个位置
     * @param index
     * @param data       添加数据
     * @return boolean
     */
    @Override
    public boolean add(int index, T data) {
        if (index >0 && index < length()){
            // 查找index位置之前的
            Node front = this.head;
            for (int i = 0; i < index - 1; i++) {
                front = front.next;
            }
            /*Node<T> before = front.next;
            Node<T> newNode = new Node<T>(data);
            front.next = newNode;
            newNode.next = before;*/
            // 相当于 front.next = new Node<T>(data,front.next);
            front.next = new Node<T>(data,front.next);
            size++;
            return true;
        }
        return false;
    }

    /**
     * @author: tongrongbing
     * @description:            更新指定位置的链表元素，并且返回旧的值
     * @time: 2020/10/27 1:42 下午
     * @param index
     * @param data
     * @return T
     */
    @Override
    public T set(int index, T data) {
        if (index < 0 || index > length()-1){
            throw new IllegalArgumentException("参数有误...");
        }
        // 找到指定位置之前的元素
        Object returnValue = null;
        if (this.head != null){
            Node node = this.head;
            int count = 0;
            while (node.next != null && count < index){
                node = node.next;
                count++;
            }
            returnValue = node.data;
            node.data = data;
        }
        return (T) returnValue;
    }

    /**
     * @author: tongrongbing
     * @description:            删除指定位置上的元素
     * @time: 2020/10/27 2:41 下午
     * @param index
     * @return T
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index > length()-1){
            throw new IllegalArgumentException("参数有误...");
        }
        T old = null;
        if (index == 0){
            Node<T> removedNode = this.head;
            old = removedNode.data;
            this.head = removedNode.next;
            removedNode.next = null;
            removedNode.data = null;
        }else{
            Node<T> node = this.head;
            int count = 0;
            // 获取index索引之前的第一个元素
            while (node.next != null && count < index-1){
                node = node.next;
                count++;
            }
            Node<T> removedNode  = node.next;
            old = removedNode.data;
            Node<T> after = removedNode.next;
            node.next = after;
            removedNode.next = null;
            removedNode.data = null;
        }
        size--;
        return old;
    }

    @Override
    public boolean removeAll(T data) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int length() {
        return size;
    }

    /**
     * @author: tongrongbing
     * @description:            获取指定位置上的元素
     * @time: 2020/10/27 2:30 下午
     * @param index
     * @return T
     */
    @Override
    public T get(int index) {
        if (index < 0 || index > length()-1){
            throw new IllegalArgumentException("参数有误...");
        }
        if (this.head != null){
            Node node = this.head;
            int count = 0;
            while (node.next != null && count < index){
                node = node.next;
                count++;
            }
               return (T) node.data;
        }
       return null;
    }

    /**
     * @author: tongrongbing
     * @description:            清空链表
     * @time: 2020/10/27 4:00 下午
     * @param
     * @return void
     */
    @Override
    public void clear() {
        if (this.head == null){
            return;
        }
        Node<T> node = this.head;
        while (node.next != null){
            Node<T> next = node.next;
            node.next = null;
            node.data = null;
            node = next;
        }
        this.head = null;
        size = 0;
    }

    /**
     * @author: tongrongbing
     * @description:                判断链表中是否包含某个元素
     * @time: 2020/10/27 4:18 下午
     * @param data
     * @return boolean
     */
    @Override
    public boolean contains(T data) {
        if (this.head == null){
            return false;
        }
        return indexOf(data) != -1;
    }

    public int indexOf(Object o){
        int index = 0;
        if (o == null){
            for (Node<T> node = this.head; node.next != null; node = node.next) {
                if (node.data == null)
                    return index;
                index++;
            }
        }else {
            for (Node<T> node = this.head; node.next != null; node = node.next){
                if (o.equals(node.data))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node<T> node = this.head;
        if (node == null){
            return null;
        }
        while (node != null){
            sb.append(node.data+"->");
            node = node.next;
        }
        sb.append("null");
        return sb.toString();
    }

}
