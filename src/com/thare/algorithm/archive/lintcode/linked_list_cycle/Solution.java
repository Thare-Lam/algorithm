package com.thare.algorithm.archive.lintcode.linked_list_cycle;

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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        for (;;) {
            if (node1.next == null) {
                return false;
            }
            node1 = node1.next;
            if (node2.next == null || node2.next.next == null) {
                return false;
            }
            node2 = node2.next.next;
            if (node1 == node2) {
                return true;
            }
        }
    }
}
