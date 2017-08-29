package lintcode.copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode copy = new RandomListNode(0);
        RandomListNode cursor = head;
        RandomListNode copyCursor = copy;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while (cursor != null) {
            RandomListNode temp = new RandomListNode(cursor.label);
            map.put(cursor, temp);
            copyCursor.next = temp;
            copyCursor = copyCursor.next;
            cursor = cursor.next;
        }
        cursor = head;
        copyCursor = copy.next;
        while (copyCursor != null) {
            copyCursor.random = map.get(cursor.random);
            copyCursor = copyCursor.next;
            cursor = cursor.next;
        }
        return copy.next;
    }
}
