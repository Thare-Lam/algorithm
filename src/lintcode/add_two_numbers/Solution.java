package lintcode.add_two_numbers;

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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int v, v1, v2;
        int carry = 0;
        while (l1 != null || l2 != null) {
            v1 = l1 == null ? 0 : l1.val;
            v2 = l2 == null ? 0 : l2.val;
            v = v1 + v2 + carry;
            if (v > 9) {
                v -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(v);
            cur.next = node;
            cur = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            cur.next = node;
        }
        return head.next;
    }

}
