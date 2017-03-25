package  com.ben.alg;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
/**
 * Created by Administrator on 2017/3/23.
 */
public class Percolation {
    private  WeightedQuickUnionUF wuf;
    private  int vtop;
    private  int vbottom;
    private  boolean[] status;
    private  int gridLength;
    private  int openSize;


    // create n-by-n grid, with all sites blocked
    public Percolation(int n){
        if(n<=0) {
            throw  new IllegalArgumentException("N is less than 0");
        }

        wuf = new WeightedQuickUnionUF(n*n+2);
        vtop = n*n;
        vbottom = n*n+1;
        gridLength = n;
        status = new boolean[n*n+2];
        openSize = 0;
    }

    /**
     * validate the index out  of bound
     * row col the postion of the index
     */
    public  boolean validateBound(int row,int col){
        if(row<0||col<0||row>gridLength||col>gridLength) return  false;
        return  true;
    }

    /**
     * convert 2-d to 1-d index
     */
    public  int indexConvertor(int row,int col){
        return  row*gridLength+col;
    }


    // open site (row, col) if it is not open already
    public    void open(int row, int col){
        if(validateBound(row,col)){
            if(isOpen(row, col))  return;
            openSize++;
            int curIndex =indexConvertor(row,col);
            if(row==0){
                wuf.union(curIndex,vtop);
            }
            if(row ==gridLength-1){
                wuf.union(curIndex,vbottom);
            }
            if(row>0){
                int downIndex = indexConvertor(row+1,col);
                if(isOpen(row+1,col)){
                    wuf.union(curIndex,downIndex);
                }
            }
            if(row<gridLength-1){
                int upIndex = indexConvertor(row-1,col);
                if(isOpen(row-1,col)){
                    wuf.union(curIndex,upIndex);
                }
            }
            if(col<gridLength-1){
                if(isOpen(row,col+1)){
                    wuf.union(curIndex,curIndex+1);
                }
            }
            if(col>0){
                if (isOpen(row,col-1)){
                    wuf.union(curIndex,curIndex-1);
                }
            }
        }

    }
    // is site (row, col) open?
    public boolean isOpen(int row, int col){
        return  status[indexConvertor(row,col)];
    }
    // is site (row, col) full?
    public boolean isFull(int row, int col){
        if (!isOpen(row, col)){
            return false;
        }
        return  wuf.connected(indexConvertor(row,col),vtop);
    }
    // number of open sites
    public     int numberOfOpenSites(){

        return  openSize;
    }
    // does the system percolate?
    public boolean percolates(){
        return  wuf.connected(vbottom,vtop);
    }
    // test client (optional)
    public static void main(String[] args){
        Percolation perc = new Percolation(3);
        perc.open(1, 2);
        perc.open(2, 2);
        perc.open(2, 3);
        perc.open(3, 3);
        boolean c = perc.isFull(1, 1);
        //boolean c1 = perc.uf.connected(perc.ijTo1D(1, 1), perc.ijTo1D(2, 1));
        //boolean c2 = perc.percolates();
        StdOut.println(c);
        //StdOut.println(c1);
        //StdOut.println(c2);
    }
}
