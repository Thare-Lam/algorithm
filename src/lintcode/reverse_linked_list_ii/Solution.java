package lintcode.reverse_linked_list_ii;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode mid = null;
        ListNode head2 = head;
        int k = m;
        while (k-- > 1) {
            mid = head2;
            head2 = head2.next;
        }
        ListNode tail = head2;
        n -= m;
        while (n-- > -1) {
            tail = tail.next;
        }
        ListNode keep = head2;
        ListNode pre = tail;
        while (keep != tail) {
            head2 = keep;
            keep = keep.next;
            head2.next = pre;
            pre = head2;
        }
        if (m > 1) {
            mid.next = head2;
            return head;
        } else {
            return head2;
        }
    }
}
