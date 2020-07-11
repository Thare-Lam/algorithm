package com.thare.algorithm.tree;

import java.util.Deque;
import java.util.LinkedList;

public class LevelOrderVisit {

    public static void main(String[] args) {
        visit(TestUtil.TREE);
    }

    public static void visit(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        TreeNode last = root;
        while (!deque.isEmpty()) {
            TreeNode cur = deque.poll();
            cur.visit();
            if (cur.left != null) {
                deque.offer(cur.left);
            }
            if (cur.right != null) {
                deque.offer(cur.right);
            }
            if (cur == last) {
                System.out.println();
                last = deque.peekLast();
            }
        }
    }

}
