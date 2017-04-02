package com.ben.bag;

/**
 * Created by Administrator on 2017/4/3.
 */
public class LinkedStackofStrings {
    private Node first = null;

    private class  Node{
        String item;
        Node next;
    }

    public  boolean isEmpty(){
        return  first ==null;
    }

    public  void  push(final  String item){
        Node pre =  first;
        first = new Node();
        first.item = item;
        first.next = pre;
    }

    public  String  pop(){
        String item = first.item;
        first= first.next;
        return item;
    }
}
