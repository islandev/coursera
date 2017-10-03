package com.ben.leetcode;

/**
 * Created by ben.wang on 2017/9/25.
 */

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the
 * two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */

public class MedianOfTwoSortedArray {

  public static void main(String[] args) {
    System.out.println("a");
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int length1 = nums1.length;
    int length2 = nums2.length;
    if (length1 * length2 == 0) {
      return length1 == 0 ? getMedian(nums2) : getMedian(nums1);
    }

    return 0;
  }


  public double findMedian(int[] array, int low, int high, int offset) {

    return 0;
  }

  double getMedian(int[] nums) {
    int length = nums.length;
    if (length == 0) {
      return -1;
    }
    return length % 2 == 0 ? (nums[length / 2 - 1] + nums[length / 2]) / 2 : nums[length / 2];
  }


}