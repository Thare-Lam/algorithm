package com.thare.algorithm.archive.lintcode.reverse_linked_list;


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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode keep = head;
        ListNode pre = null;
        while (keep != null) {
            head = keep;
            keep = keep.next;
            head.next = pre;
            pre = head;
        }
        return head;
    }
}
