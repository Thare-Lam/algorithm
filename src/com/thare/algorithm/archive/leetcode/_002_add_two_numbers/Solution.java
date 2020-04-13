package com.thare.algorithm.archive.leetcode._002_add_two_numbers;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int s;
        int k = 0;
        ListNode node;
        while (l1 != null && l2 != null) {
            s = l1.val + l2.val + k;
            k = s / 10;
            s %= 10;
            node = new ListNode(s);
            cur.next = node;
            cur = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            f(cur, l1, k);
        } else if (l2 != null) {
            f(cur, l2, k);
        } else if (k > 0) {
            node = new ListNode(1);
            cur.next = node;
        }
        return head.next;
    }

    private int f(ListNode cur, ListNode l, int k) {
        int s;
        ListNode node;
        while (l != null) {
            s = l.val + k;
            k = s / 10;
            s %= 10;
            node = new ListNode(s);
            cur.next = node;
            cur = node;
            l = l.next;
        }
        if (k > 0) {
            node = new ListNode(1);
            cur.next = node;
        }
        return k;
    }

}
