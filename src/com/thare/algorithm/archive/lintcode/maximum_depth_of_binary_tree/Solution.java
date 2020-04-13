package com.thare.algorithm.archive.lintcode.maximum_depth_of_binary_tree;

import java.util.Stack;

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
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> traceStack = new Stack<TreeNode>();
        int max = 0;
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                root = stack.peek();
                if (!traceStack.isEmpty() && traceStack.peek() == root) {
                    traceStack.pop();
                } else if (root.right != null) {
                    traceStack.push(root);
                    root = root.right;
                    continue;
                } else {
                    if (root.left == null) {
                        max = Math.max(max, stack.size());
                    }
                }
                stack.pop();
                root = null;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        t1.right = t2;
        t2.left = t3;
        new Solution().maxDepth(t1);
    }

}
