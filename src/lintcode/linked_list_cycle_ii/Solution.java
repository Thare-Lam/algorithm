package lintcode.linked_list_cycle_ii;

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
     * @return: The node where the cycle begins.
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        for (;;) {
            if (node1.next == null) {
                return null;
            }
            node1 = node1.next;
            if (node2.next == null || node2.next.next == null) {
                return null;
            }
            node2 = node2.next.next;
            if (node1 == node2) {
                ListNode node3 = head;
                while (node1 != node3) {
                    node1 = node1.next;
                    node3 = node3.next;
                }
                return node1;
            }
        }
    }
}
