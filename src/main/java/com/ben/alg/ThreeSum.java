package com.ben.alg;

/**
 * Created by Administrator on 2017/3/26.
 */
public class ThreeSum {
    public int counter(int[] a){
        int count = 0;
        int length = a.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                for (int k=j+1;j<length;j++){
                    if(a[i]+a[j]+a[k]==0){
                        count++;
                    }
                }
            }
        }
        return  count;
    }
}
