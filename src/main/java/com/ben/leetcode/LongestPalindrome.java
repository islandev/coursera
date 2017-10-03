package com.ben.leetcode;


/**
 * Created by ben.wang on 2017/10/3.
 */

public class LongestPalindrome {

  public  static String longestPalindrome(String s) {
    char[] chars = s.toCharArray();
    int length = chars.length;
    int max = 0;
    int startIndex = 0;
    int endIndex = 0;
    for (int i = 1; i < length; i++) {
      int tmpMid = calMidCount(chars, i, length);
      int intervalM = tmpMid * 2 + 1;
      int tmpSplit = calSplitCount(chars, i, length);
      int intervalS = tmpSplit * 2;

      int max1 = Math.max(intervalM, intervalS);
      if (max < max1) {

        max = max1;
        if (max % 2 == 0) {
          startIndex = i - max / 2;
          endIndex = i + max / 2 - 1;
        } else {
          startIndex = i - max / 2;
          endIndex = i + max / 2;
        }
      }
    }
    return s.substring(startIndex, endIndex + 1);
  }

  static int calMidCount(char[] chars, int index, int length) {
    int count = 0;
    while (true) {
      int low;
      int high;
      if ((low = index - count) < 0 || (high = index + count) >= length) {
        break;
      }
      if (chars[low] != chars[high]) {
        break;
      }
      count++;
    }
    return count - 1;
  }


  static  int calSplitCount(char[] chars, int index, int length) {
    int count = 1;
    while (true) {
      int low;
      int high;
      if ((low = index - count) < 0 || (high = index + count-1) >= length) {
        break;
      }
      if (chars[low] != chars[high]) {
        break;
      }
      count++;
    }
    return count-1;
  }

  public static void main(String[] args) {
    System.out.printf(longestPalindrome("ccccc"));
  }
}
