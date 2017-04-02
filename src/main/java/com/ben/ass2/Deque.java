package com.ben.ass2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/4/3.
 */
public class Deque<Item> implements Iterable<Item> {
    private Stack<Item>  stack;
    private Queue<Item>  queue;
    public Deque(){

    }
    public boolean isEmpty(){
        return  stack.isEmpty()&&queue.isEmpty();
    }
    public int size(){
        return  stack.size()+queue.size();
    }
    public void addFirst(Item item){
        queue.enqueue(item);
    }
    public void addLast(Item item){
        stack.push(item);
    }
    public Item removeFirst(){
        return  queue.dequeue();
    }               // remove and return the item from the front
    public Item removeLast(){
        return  stack.pop();
    }                // remove and return the item from the end
    public Iterator<Item> iterator(){
        
    }        // return an iterator over items in order from front to end
    public static void main(String[] args){

    }  // unit testing (optional)
}
