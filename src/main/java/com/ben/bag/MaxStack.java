package com.ben.bag;

/**
 * Created by Administrator on 2017/4/3.
 */
public class MaxStack {
    private Node first;     // top of stack
    private Integer n;
    private  Integer max = Integer.MIN_VALUE;


    private static class Node {
        private int item;
        private Node next;
    }

    public  void push(int val){
        max = max>val?max:val;
        Node pre = first;
        first.item = val;
        first.next =pre;
        n++;
    }

    public  int pop(){
        if(isEmpty()) return  -1;
        int val = first.item;
        Node next = first.next;
        first.next = next;
        if(max == val)  getMax();
        return  val;



    }

    public void getMax(){
        max = Integer.MIN_VALUE;
        Node node = first;
        while (node.next!=null){
            max = max>node.item?max:node.item;
            node = node.next;
        }
    }
    public  boolean isEmpty(){return  n==0;}


}
