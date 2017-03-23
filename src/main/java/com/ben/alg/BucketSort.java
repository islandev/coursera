package com.ben.alg;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/13.
 */
public class BucketSort {
    public static void main(String[] args)   {
        int[] a = {4,6,2,5,6,8,7,9,1};
        int len = a.length - 1;
        int beginIndex = (len - 1) >> 1;


        for(int i = beginIndex; i >= 0; i--){
            maxHeapify(a, i,len);
        }
        System.out.println(Arrays.toString(a));


        for(int i = len; i > 0; i--){
            swap(0, i,a);
            maxHeapify(a, 0,i-1);
        }
        System.out.print(Arrays.toString(a));
    }


    public  static  void maxHeapify(int[] a, int n,int len){

        int leftChild = (n<<1)+1;
        int rightChild = leftChild +1;
        int larger = leftChild;
        if(leftChild>len) return;
        if(rightChild<=len&&a[rightChild]>a[leftChild]){
            larger=rightChild;
        }
        if(a[larger]>a[n]){
            swap(larger,n,a);
            maxHeapify(a,larger,len);
        }

    }

    public  static  void swap(int i,int j,int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



}
