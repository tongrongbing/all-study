package com.wenba.studydemo.datastructure.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/22 5:23 下午
 * @description：
 */
public class MyStack<E> {

    private Object[] elements;

    private int elementCount;

    private int top;

    public MyStack(){
        init();
    }

    private void init() {
        elements = new Object[10];
        top = -1;
    }

    public MyStack(int initCapacity){
        if (initCapacity < 0){
            throw new RuntimeException("小于0。。。");
        }
        elements = new Object[initCapacity];
    }

    public boolean push(E e){
        ensureCapacityHelper(elementCount + 1);
        elements[elementCount++] = e;
        return true;
    }

    public E pop(){
        E obj;
        int len = size();
        obj = peek();
        removeElementAt(len - 1);
        return obj;
    }

    public void removeElementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                    elementCount);
        }
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int destLength = elementCount-1-index;
        if (destLength > 0){
            System.arraycopy(elements,index,elements,index+1,destLength);
        }
        elementCount--;
        elements[elementCount] = null;
    }

    public E peek() {
        int len = size();
        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }

    public E elementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }
        return elementData(index);
    }

     E elementData(int index) {
        return (E) elements[index];
     }

    public int size() {
        return elementCount;
    }
    public void ensureCapacityHelper(int minCapacity) {
        if (minCapacity - elements.length > 0)
            grow(minCapacity);
    }

    public void grow(int minCapacity) {
        int oldCapacity = elements.length;  // 数组容量
        if(oldCapacity < minCapacity){ // 需要扩容
            minCapacity = oldCapacity << 1; // 扩大一倍
            int newCapacity = hugeCapacity(minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public void getElements(){
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] +" ");
        }
    }
    private static int hugeCapacity(int minCapacity){
        if (minCapacity < 0){
            throw new OutOfMemoryError();
        }
        return (minCapacity > Integer.MAX_VALUE -8) ? Integer.MAX_VALUE : minCapacity;
    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        for (int i = 0; i < 11 ; i++) {
            myStack.push(i);
        }
        myStack.getElements();
        System.out.println();
        System.out.println(myStack.pop());
        myStack.getElements();
        System.out.println();
        myStack.removeElementAt(5);
        myStack.getElements();

        /*System.out.println(myStack.elements.length);

        int[] array = new int[20];
        for (int i = 0; i <10 ; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));
        System.arraycopy(array,3,array,2,7);
        array[10-1] = 0;
        System.out.println(Arrays.toString(array));*/

    }

}
