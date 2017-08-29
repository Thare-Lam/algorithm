package lintcode.merge_two_sorted_lists;

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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode iter = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }
        if (l1 != null) {
            iter.next = l1;
        } else {
            iter.next = l2;
        }
        return result.next;
    }
}
