package com.thare.algorithm.tree;

import java.util.Stack;

public class MiddleOrderVisit {

    public static void main(String[] args) {
        visitRecursion(TestUtil.TREE);
        System.out.println();
        visit(TestUtil.TREE);
        System.out.println();
        morrisVisit(TestUtil.TREE);
    }

    public static void visit(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root.visit();
                root = root.right;
            }
        }
    }

    public static void visitRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        visitRecursion(root.left);
        root.visit();
        visitRecursion(root.right);
    }

    public static void morrisVisit(TreeNode root) {
        TreeNode pre;
        while (root != null) {
            if (root.left == null) {
                root.visit();
                root = root.right;
            } else {
                pre = getPre(root);
                if (pre.right == root) {
                    root.visit();
                    pre.right = null;
                    root = root.right;
                } else {
                    pre.right = root;
                    root = root.left;
                }
            }
        }
    }

    private static TreeNode getPre(TreeNode node) {
        TreeNode pre = node;
        if (node.left != null) {
            pre = node.left;
            while (pre.right != null && pre.right != node) {
                pre = pre.right;
            }
        }
        return pre;
    }

}
