package com.wenba.studydemo.datastructure.stack;

import java.util.Arrays;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/23 2:07 下午
 * @description：
 */
public class Stack<E> {

    private Object[] elementData;

    private int size;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public Stack(){
        elementData = new Object[10];
    }

    public Stack(int initCapacity){
        elementData = new Object[initCapacity];
    }

    // 往栈添加元素
    public boolean push(E e){
        // 确认是否需要扩容
        ensureCapacityHelper(size + 1);
        elementData[size++] = e;
        return true;
    }

    // 栈顶弹出元素
    public E pop(){
        E obj;
        obj = peek();
        removeElementAt(size - 1);
        return obj;
    }

    private void removeElementAt(int index) {
        if (index >= size || index < 0){
            throw new IllegalArgumentException("参数有误");
        }
        // 重新对数组进行移动
        int length = size - 1 - index;
        if (length > 0)
            System.arraycopy(elementData,index+1,elementData,index,length);
        elementData[--size] = null;
    }

    private E peek() {
        return elementAt(size-1);
    }

    private E elementAt(int index){
        if (index >= size || index < 0){
            throw new IllegalArgumentException("参数有误");
        }
        return (E)elementData(index);
    }

    private Object elementData(int index) {
        return elementData[index];
    }

    public int size(){
        return size;
    }
    private void ensureCapacityHelper(int minCapacity) {
        if (minCapacity > elementData.length)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + oldCapacity << 1;
        if(newCapacity - minCapacity < 0){
            newCapacity = minCapacity;
        }
        if (newCapacity  - MAX_ARRAY_SIZE > 0){
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData,newCapacity);

    }

    private int hugeCapacity(int minCapacity) {
        if(minCapacity < 0){
            throw new OutOfMemoryError();
        }
        return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : minCapacity;
    }

    public void getElements(){
        for (int i = 0; i < elementData.length; i++) {
            System.out.print(elementData[i] +" ");
        }
    }
    public boolean empty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();
        for (int i = 0; i < 8 ; i++) {
            myStack.push(i);
        }
        myStack.getElements();
        System.out.println();
        myStack.removeElementAt(5);
        myStack.getElements();


    }

}
