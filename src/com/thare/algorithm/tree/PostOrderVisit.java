package com.thare.algorithm.tree;

import java.util.Stack;

public class PostOrderVisit {

    public static void main(String[] args) {
        visitRecursion(TestUtil.TREE);
        System.out.println();
        visit(TestUtil.TREE);
    }

    public static void visit(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode lastVisit = root;
        TreeNode stackTop;
        while (!stack.isEmpty()) {
            stackTop = stack.peek();
            if (stackTop.left != null && lastVisit != stackTop.left && lastVisit != stackTop.right) {
                stack.push(stackTop.left);
            } else if (stackTop.right != null && lastVisit != stackTop.right) {
                stack.push(stackTop.right);
            } else {
                lastVisit = stack.pop();
                lastVisit.visit();
            }
        }
    }

    public static void visitRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        visitRecursion(root.left);
        visitRecursion(root.right);
        root.visit();
    }

}
