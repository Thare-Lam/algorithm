package lintcode.intersection_of_two_linked_lists;

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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        int gap;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            ++lenA;
            curA = curA.next;
        }
        curA = headA;
        while (curB != null) {
            ++lenB;
            curB = curB.next;
        }
        curB = headB;
        gap = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            curA = forwardN(curA, gap);
        } else {
            curB = forwardN(curB, gap);
        }
        if (curA == null || curB == null) {
            return null;
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    private ListNode forwardN(ListNode node, int n) {
        while (--n >= 0) {
            node = node.next;
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}
