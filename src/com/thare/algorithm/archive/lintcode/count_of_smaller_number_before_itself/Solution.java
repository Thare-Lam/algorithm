package com.thare.algorithm.archive.lintcode.count_of_smaller_number_before_itself;

import java.util.*;

public class Solution {

    class SegmentTreeNode {
        public int start, end, count;

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
        SegmentTreeNode root = build(0, 10000);
        List<Integer> res = new ArrayList<>(A.length);
        for (int i = 0; i < A.length; ++i) {
            res.add(query(root, 0, A[i] - 1));
            add(root, A[i]);
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

    private void add(SegmentTreeNode root, int target) {
        ++root.count;
        if (target == root.start && target == root.end) {
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (target <= mid) {
            add(root.left, target);
        } else {
            add(root.right, target);
        }
    }

    private int query(SegmentTreeNode root, int start, int end) {
        if (start > end || root == null) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.count;
        }
        int mid = (root.start + root.end) / 2;
        if (start > mid) {
            return query(root.right, start, end);
        } else if (end <= mid) {
            return query(root.left, start, end);
        } else {
            return query(root.left, start, mid) + query(root.right, mid + 1, end);
        }
    }

}

