package lintcode.binary_tree_zigzag_level_order_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include
     *          the zigzag level order traversal of its nodes' values
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> row = new ArrayList<Integer>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        TreeNode node;
        TreeNode last = root;
        TreeNode nLast = null;
        queue.add(last);
        boolean lr = true;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (lr) {
                row.add(node.val);
            } else {
                row.add(0, node.val);
            }
            if (node.left != null) {
                nLast = node.left;
                queue.add(nLast);
            }
            if (node.right != null) {
                nLast = node.right;
                queue.add(nLast);
            }
            if (node == last) {
                lr = !lr;
                last = nLast;
                result.add(row);
                row = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
