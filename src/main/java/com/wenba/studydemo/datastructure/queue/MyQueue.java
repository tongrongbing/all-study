package com.wenba.studydemo.datastructure.queue;

import java.util.Arrays;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/26 2:42 下午
 * @description： 基于数组形式的队列
 */
public class MyQueue<E> {

    private Object[] queue; // 存储的元素
    private int head;
    private int tail;
    private int size; // 队列实际元素的大小
    private int capacity; // 队列初始化容量

    public MyQueue(int initCapacity){
        this.capacity = initCapacity;
        this.queue =  new Object[initCapacity];
        head = tail = 0;
    }

    public boolean add(E e){
        ensureCapacityHelper();
        queue[tail] = e;
        // 计算tail
        this.tail = (tail+1) % capacity;
        size++;
        return true;
    }

    public void ensureCapacityHelper(){
        if(capacity == this.size()){
            // 扩容,省略数组大小校验
            int oldCapacity = queue.length;
            int newCapacity = oldCapacity  + oldCapacity << 1;
            this.capacity = newCapacity;
            this.queue = Arrays.copyOf(queue,newCapacity);
            // 恢复head , tail指向
            this.head = 0;
            this.tail = this.size();
        }
    }
    public E poll(){
       if(size() == 0){
           throw new IndexOutOfBoundsException("Queue is empty");
       }
       E e = (E) queue[head];
       queue[head]  = null;
        // 计算head
       this.head = (head + 1) % capacity;
       size--;
       return e;
    }

    public int size(){
        return size;
    }
    public void printData(){
        System.out.println();
        for (int i = 0; i < queue.length; i++) {
            System.out.print(queue[i] + "   ");
        }
    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(6);
        for (int i = 0; i < 6 ; i++) {
            myQueue.add("字符" + i);
        }
        myQueue.printData();
        myQueue.poll();
        myQueue.poll();

        myQueue.printData();
        myQueue.add("A");
        myQueue.add(2222);
        myQueue.printData();
        myQueue.add("扩容后的第一个元素A");
        myQueue.add("扩容后的第二个元素B");
        myQueue.printData();
        System.out.println();
        System.out.println(myQueue.capacity);
        System.out.println(myQueue.size());
    }
}
