package com.ben.alg;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
/**
 * Created by Administrator on 2017/3/23.
 */
public class Percolation {
    private  int  row;



    // create n-by-n grid, with all sites blocked
    public Percolation(int n){
        if(n<=0) {
            throw  new IllegalArgumentException("N is less than 0");
        }

    }
    // open site (row, col) if it is not open already
    public    void open(int row, int col){

    }
    // is site (row, col) open?
    public boolean isOpen(int row, int col){
        return  false;
    }
    // is site (row, col) full?
    public boolean isFull(int row, int col){
        return  false;
    }
    // number of open sites
    public     int numberOfOpenSites(){
        return  0;
    }
    // does the system percolate?
    public boolean percolates(){
        return  false;
    }
    // test client (optional)
    public static void main(String[] args){

    }
}
