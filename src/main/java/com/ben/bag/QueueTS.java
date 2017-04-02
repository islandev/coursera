package com.ben.bag;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by Administrator on 2017/4/3.
 */
public class QueueTS<T> {
    private  Stack<T>  inStack;
    private  Stack<T>  outStack;

    public  void enqueue(T item){
        inStack.push(item);
    }

    public  T dequeue(){
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return  outStack.pop();
    }

    public boolean isEmpty(){
        return  inStack.isEmpty()&&outStack.isEmpty();
    }
}
