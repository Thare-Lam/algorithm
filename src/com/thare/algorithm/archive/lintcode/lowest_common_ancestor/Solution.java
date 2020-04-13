package com.thare.algorithm.archive.lintcode.lowest_common_ancestor;

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
     * @param root: The root of the binary search tree.
     * @param a and b: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> traceStack = new Stack<TreeNode>();
        TreeNode common = root;
        boolean visited = false;
        boolean same = false;
        if (a == b) {
            same = true;
        }
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                root = stack.peek();
                if (!traceStack.isEmpty() && traceStack.peek() == root) {
                    traceStack.pop();
                } else if (root.right != null) {
                    traceStack.push(root);
                    root = root.right;
                    continue;
                }
                stack.pop();
                if (root == common) {
                    common = stack.peek();
                }
                root = null;
            } else {
                stack.push(root);
                if (root == a || root == b) {
                    if (same) {
                        return root;
                    }
                    if (visited) {
                        return common;
                    }
                    visited = true;
                    common = root;
                }
                root = root.left;
            }
        }
        return null;
    }
}
