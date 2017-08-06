package com.ben.chap2;

import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

  double time(String alg, Comparable[] a) {
    Stopwatch timer = new Stopwatch();
    switch (alg) {
      case "Insertion":
        new Insertion().sort(a);
      case "Selection":
        new Selection().sort(a);
    }
    return timer.elapsedTime();
  }
}
