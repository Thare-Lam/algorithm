package com.thare.algorithm.archive.lintcode.segment_tree_query_ii;

class SegmentTreeNode {
    public int start, end, count;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.count = max;
        this.left = this.right = null;
    }
}

public class Solution {
    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (start > end || root == null || (end < root.start && start > root.end)) {
            return 0;
        }
        if (start == root.start && end == root.end) {
            return root.count;
        }
        start = Math.max(start, root.start);
        end = Math.min(end, root.end);
        int mid = (root.start + root.end) / 2;
        if (end <= mid) {
            return query(root.left, start, end);
        } else if (start >= mid + 1) {
            return query(root.right, start, end);
        } else {
            return query(root.left, start, mid) + query(root.right, mid + 1, end);
        }
    }
}
