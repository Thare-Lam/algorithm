package com.thare.algorithm.tree;

import java.util.Stack;

public class PreOrderVisit {

    public static void main(String[] args) {
        visitRecursion(TestUtil.TREE);
        System.out.println();
        visit(TestUtil.TREE);
    }

    public static void visit(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                root.visit();
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static void visitRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        root.visit();
        visitRecursion(root.left);
        visitRecursion(root.right);
    }

}
