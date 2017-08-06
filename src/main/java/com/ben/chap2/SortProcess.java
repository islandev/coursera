package com.ben.chap2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.stream.IntStream;

public abstract class SortProcess {

  abstract void sort(Comparable[] a);

  boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  void show(Comparable[] a) {
    for (Comparable val : a) {
      StdOut.print(val + "\t");
    }
    StdOut.println();
  }

  void showPic(int[] a) {
    StdDraw.clear();
    double[] b = IntStream.range(0, a.length).asDoubleStream().toArray();
    double[] doubles = IntStream.of(a).asDoubleStream().toArray();
    StdDraw.filledPolygon(doubles, b);
  }

  boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }


}
