package com.ben.leetcode;

/**
 * Created by ben.wang on 2017/9/25.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters Given a string, find the length of the longest
 * substring without repeating characters. Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a
 * substring, "pwke" is a subsequence and not a substring
 */
public class LSSRC {

  public static int lengthOfLongestSubstring(String s) {
    int length = s.length();
    if (length == 0) {
      return 0;
    }
    int count = 0;
    List<Character> characters = new ArrayList<>();
    int max = -1;
    char[] chars = s.toCharArray();
    for (int i = 0; i < length; i++) {
      char target;
      if (characters.contains(target = chars[i])) {
        int i1 = characters.indexOf(target);
        count -= i1;
        characters = characters.subList(i1 + 1, characters.size());
        characters.add(target);
      } else {
        count++;
        characters.add(target);
        max = max > count ? max : count;
      }

    }
    return max;
  }


  public static int lssrc(String s) {
    int length = s.length();
    int ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0, j = 0; i < length; i++) {
      char target;
      int index;
      if (map.containsKey(target = s.charAt(i)) && (index = map.get(target)) >= j) {
        j = index + 1;
        ans = Math.max(ans, i - j);
      } else {
        ans = Math.max(ans, i - j + 1);
      }
      map.put(target, i);
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(lssrc("au"));
    System.out.println(lssrc("C"));
    System.out.println(lssrc("abcabcbb"));
    System.out.println(lssrc("tmmzuxt"));
    System.out.println(lssrc("bbbbb"));
    System.out.println(lssrc("pwwkew"));
  }

}