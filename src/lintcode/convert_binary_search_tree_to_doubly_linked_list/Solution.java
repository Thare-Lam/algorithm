package lintcode.convert_binary_search_tree_to_doubly_linked_list;

import java.util.Stack;

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class DoublyListNode {
    int val;
    DoublyListNode next, prev;

    DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}

public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        DoublyListNode cursor = new DoublyListNode(0);
        DoublyListNode temp = cursor;
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                root = stack.pop();
                DoublyListNode dNode = new DoublyListNode(root.val);
                cursor.next = dNode;
                dNode.prev = cursor;
                cursor = dNode;
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        temp = temp.next;
        temp.prev = null;
        return temp;
    }
}
