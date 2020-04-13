package com.thare.algorithm.archive.lintcode.remove_nth_node_from_end_of_list;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode last = head;
        while (n-- > 0) {
            last = last.next;
        }
        if (last == null) {
            return head.next;
        }
        while (last.next != null) {
            last = last.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
