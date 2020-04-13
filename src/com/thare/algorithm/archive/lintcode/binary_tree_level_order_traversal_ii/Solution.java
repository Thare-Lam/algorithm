package com.thare.algorithm.archive.lintcode.binary_tree_level_order_traversal_ii;

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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
        while (!queue.isEmpty()) {
            node = queue.poll();
            row.add(node.val);
            if (node.left != null) {
                nLast = node.left;
                queue.add(nLast);
            }
            if (node.right != null) {
                nLast = node.right;
                queue.add(nLast);
            }
            if (node == last) {
                last = nLast;
                result.add(0, row);
                row = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
