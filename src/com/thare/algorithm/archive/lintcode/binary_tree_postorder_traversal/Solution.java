package com.thare.algorithm.archive.lintcode.binary_tree_postorder_traversal;

import java.util.ArrayList;
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> traceStack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                root = stack.peek();
                if (!traceStack.isEmpty() && root == traceStack.peek()) {
                    traceStack.pop();
                } else if (root.right != null) {
                    traceStack.push(root);
                    root = root.right;
                    continue;
                }
                result.add(stack.pop().val);
                root = null;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return result;
    }
}
