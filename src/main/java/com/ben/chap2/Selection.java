package com.ben.chap2;

public class Selection extends SortExample {

  void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
        exch(a, i, min);
      }
    }
  }

  public static void main(String[] args) {
    Selection selection = new Selection();
    String[] a = new String[]{"a", "e", "b"};
    selection.sort(a);
    assert selection.isSorted(a);
    selection.show(a);
  }
}
