package com.ben.chap2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public abstract class SortExample {

  abstract  void sort(Comparable[] a);

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
      StdOut.print(val + "");
    }
    StdOut.println();
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
