package com.thare.algorithm.archive.lintcode.count_of_smaller_number;

import java.util.*;

class SegmentTreeNode {
    public int start, end, count;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
        this.left = this.right = null;
    }
}

public class Solution {

    /*
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        List<Integer> res = new ArrayList<>(queries.length);
        if (A.length == 0) {
            for (int i = 0; i < queries.length; ++i) {
                res.add(0);
            }
            return res;
        }
        Arrays.sort(A);
        SegmentTreeNode root = build(A, 0, A.length - 1, A[0], A[A.length - 1]);
        for (int m : queries) {
            res.add(query(root, 0, m - 1));
        }
        return res;
    }

    private SegmentTreeNode build(int[] A, int s, int e, int min, int max) {
        SegmentTreeNode node = new SegmentTreeNode(min, max, e - s + 1);
        if (min == max) {
            return node;
        }
        int mid = (min + max) / 2;
        int index = binarySearch(A, s, e, mid);
        node.left = build(A, s, index, min, mid);
        node.right = build(A, index + 1, e, mid + 1, max);
        return node;
    }

    private int query(SegmentTreeNode root, int start, int end) {
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

    private int binarySearch(int[] A, int s, int e, int t) {
        if (s > e) {
            return s - 1;
        }
        int mid = (s + e) / 2;
        if (A[mid] <= t) {
            if (mid + 1 <= e) {
                if (A[mid + 1] > t) {
                    return mid;
                } else {
                    return binarySearch(A, mid + 1, e, t);
                }
            } else {
                return e;
            }
        } else {
            if (mid - 1 >= s) {
                if (A[mid - 1] < t) {
                    return mid - 1;
                } else {
                    return binarySearch(A, s, mid - 1, t);
                }
            } else {
                return s - 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
        new Solution().countOfSmallerNumber(new int[]{68,64,53,93,48,3,3}, new int[]{}));
    }

}
