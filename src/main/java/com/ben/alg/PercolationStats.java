package  com.ben.alg;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by Administrator on 2017/3/23.
 */
public class PercolationStats {
    private  double[] thredhold;
    private  int l;
    private double calcTreshold(int n)
    {
        double counter = 0;
        int row, col;
        Percolation percolation = new Percolation(n);
        while (!percolation.percolates())
        {
            row = StdRandom.uniform(n)+1;
            col = StdRandom.uniform(n)+1;
            if (!percolation.isOpen(row, col))
            {
                counter++;
                percolation.open(row, col);
            }
        }
        return counter / (n*n);
    }
    public PercolationStats(int n, int trials){
        if (n < 1 || trials < 1)
        {
            throw new IllegalArgumentException();
        }
        thredhold = new double[trials];

        l=n;

        for (int i = 0; i < thredhold.length; i++)
        {
            thredhold[i] = calcTreshold(l);
        }
    }    // perform trials independent experiments on an n-by-n grid
    public double mean(){ return StdStats.mean(thredhold);}                          // sample mean of percolation threshold
    public double stddev(){        return StdStats.stddev(thredhold);
    }                        // sample standard deviation of percolation threshold
    public double confidenceLo(){return mean() - (1.96*stddev())/(Math.sqrt(l)); }                  // low  endpoint of 95% confidence interval
    public double confidenceHi(){ return mean() + (1.96*stddev())/(Math.sqrt(l));}                  // high endpoint of 95% confidence interval

    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(N, T);
        StdOut.printf("mean = %f\n", stats.mean());
        StdOut.printf("stddev = %f\n", stats.stddev());
        StdOut.printf("95%% confidence interval = %f, %f\n", stats.confidenceLo(), stats.confidenceHi());
    }
}
