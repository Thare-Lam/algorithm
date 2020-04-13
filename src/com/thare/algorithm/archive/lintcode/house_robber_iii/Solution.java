package com.thare.algorithm.archive.lintcode.house_robber_iii;

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        int[] result = dp(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] m = new int[2];
        int[] l = dp(root.left);
        int[] r = dp(root.right);
        m[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        m[1] = l[0] + root.val + r[0];
        return m;
    }
}
