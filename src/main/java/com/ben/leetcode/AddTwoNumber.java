package com.ben.leetcode;

import com.ben.base.ListNode;

/**
 * Created by ben.wang on 2017/9/25.
 */

public class AddTwoNumber {

  public ListNode addTwoNumber(ListNode l1, ListNode l2) {
    ListNode resNode = new ListNode(0);
    ListNode p = l1, q = l2, resCur = resNode;
    int carry = 0;
    while (p != null || q != null) {
      int pVal = p != null ? p.val : 0;
      int qVal = q != null ? q.val : 0;
      int sum = pVal + qVal + carry;
      resCur.next = new ListNode(sum % 10);
      resCur = resCur.next;
      carry = sum / 10;
      if (p != null) {
        p = p.next;
      }
      if (q != null) {
        q = q.next;
      }
    }
    if (carry > 0) {
      resCur.next = new ListNode(carry);
    }
    return resNode.next;
  }
}
