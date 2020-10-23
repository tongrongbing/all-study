package com.wenba.studydemo.datastructure.queue;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/23 4:27 下午
 * @description：
 */
public class ArrayQueue<T> {

    private int capacity;
    private T[] queue;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        this.capacity = capacity + 1;
        this.queue = newArray(capacity + 1);
        this.head = 0;
        this.tail = 0;
    }

    private T[] newArray(int size) {
        return (T[]) new Object[size];
    }

    public boolean add(T o) {
        queue[tail] = o;
        int newtail = (tail + 1) % capacity;
        if (newtail == head)
            throw new IndexOutOfBoundsException("Queue full");
        tail = newtail;
        return true; // we did add something
    }

    public T remove(int i) {
        if (i != 0)
            throw new IllegalArgumentException("Can only remove head of queue");
        if (head == tail)
            throw new IndexOutOfBoundsException("Queue empty");
        T removed = queue[head];
        queue[head] = null;
        head = (head + 1) % capacity;
        return removed;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.add(1);
        queue.add(12);
        queue.add(13);

        Object remove = queue.remove(0);
        queue.remove(0);

    }
}
