package com.ben.chap2;

public class Insertion extends SortProcess {


  void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 1; i < N; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
  }

  public static void main(String[] args) {
    Insertion insertion = new Insertion();
    String[] a = new String[]{"a","c","b"};
    insertion.sort(a);
    assert  insertion.isSorted(a);
    insertion.show(a);
  }
}
