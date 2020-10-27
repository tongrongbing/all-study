package com.wenba.studydemo.linkedlist;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/27 10:44 上午
 * @description：
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {

        MySingleLinkedList<Object> mySingleLinkedList = new MySingleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            mySingleLinkedList.addFirst(i);
        }
        //System.out.println(mySingleLinkedList.toString());
        mySingleLinkedList.add(3,"A");
        mySingleLinkedList.add(5,"B");
        //System.out.println("链表长度为 " +mySingleLinkedList.length() +"，" +mySingleLinkedList.toString());
        mySingleLinkedList.addLast("C");
       // System.out.println("链表长度为 " +mySingleLinkedList.length() +"，" +mySingleLinkedList.toString());
        mySingleLinkedList.addLast("D");
        mySingleLinkedList.set(7,"ZZZ");
        //System.out.println("链表长度为 " +mySingleLinkedList.length() +"，" +mySingleLinkedList.toString());

        System.out.println(mySingleLinkedList.get(4));


        System.out.println(mySingleLinkedList.remove(0));
        System.out.println(mySingleLinkedList.remove(6));
        System.out.println("链表长度为 " +mySingleLinkedList.length() +"，" +mySingleLinkedList.toString());

        //mySingleLinkedList.clear();
        //System.out.println("链表长度为 " +mySingleLinkedList.length() +"，" +mySingleLinkedList.toString());

        System.out.println(mySingleLinkedList.contains(1));

    }
}
