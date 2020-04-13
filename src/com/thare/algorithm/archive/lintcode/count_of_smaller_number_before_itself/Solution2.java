package com.thare.algorithm.archive.lintcode.count_of_smaller_number_before_itself;

import java.util.*;

public class Solution2 {

    class SegmentTreeNode {
        public int start, end, count, min, max;

        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }
    }

    /*
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> countOfSmallerNumberII(int[] A) {
        SegmentTreeNode root = build(0, A.length - 1);
        setSegmentTreeNodeMax(root, A);
        List<Integer> res = new ArrayList<>(A.length);
        for (int i = 0; i < A.length; ++i) {
            res.add(query(root, 0, i - 1, A[i]));
        }
        return res;
    }

    private SegmentTreeNode build(int s, int e) {
        if (s > e) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(s, e);
        if (s == e) {
            return node;
        }
        int mid = (s + e) / 2;
        node.left = build(s, mid);
        node.right = build(mid + 1, e);
        return node;
    }

    private void setSegmentTreeNodeMax(SegmentTreeNode root, int[] A) {
        Stack<SegmentTreeNode> stack = new Stack<>();
        Stack<SegmentTreeNode> traceStack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.peek();
                if (root.right != null) {
                    if (!traceStack.isEmpty() && traceStack.peek() == root) {
                        root.min = Math.min(root.left.min, root.right.min);
                        root.max = Math.max(root.left.max, root.right.max);
                        traceStack.pop();
                        stack.pop();
                        root = null;
                    } else {
                        traceStack.push(root);
                        root = root.right;
                    }
                } else {
                    root.min = A[root.start];
                    root.max = A[root.end];
                    stack.pop();
                    root = null;
                }
            } else {
                stack.push(root);
                root = root.left;
            }
        }
    }

    private int query(SegmentTreeNode root, int start, int end, int max) {
        if (start > end || root == null) {
            return 0;
        }
        if (root.max < max) {
            return end - start + 1;
        } else if (root.min >= max) {
            return 0;
        }
        if (start == end && root.start == root.end && start == root.start) {
            return 0;
        }
        int mid = (root.start + root.end) / 2;
        if (start > mid) {
            return query(root.right, start, end, max);
        } else if (end <= mid) {
            return query(root.left, start, end, max);
        } else {
            return query(root.left, start, mid, max) + query(root.right, mid + 1, end, max);
        }
    }

}
