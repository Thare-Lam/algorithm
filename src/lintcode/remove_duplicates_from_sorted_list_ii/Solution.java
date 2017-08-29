package lintcode.remove_duplicates_from_sorted_list_ii;

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
     * @param head is the cursor of the linked list
     * @return: ListNode cursor of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cursor = head;
        ListNode pre = null;
        ListNode last = null;
        while (cursor != null && cursor.next != null) {
            if (cursor.val == cursor.next.val) {
                cursor.next = cursor.next.next;
                last = cursor;
            } else if (cursor == last) {
                if (cursor == head) {
                    head = cursor.next;
                }
                cursor = cursor.next;
                if (pre == null) {
                    pre = cursor;
                } else {
                    pre.next = cursor;
                }
                last = null;
            } else {
                pre = cursor;
                cursor = cursor.next;
            }
        }
        if (cursor != null && cursor == last) {
            if (cursor == head) {
                head = null;
            } else {
                pre.next = null;
            }
        }
        return head;
    }
}
