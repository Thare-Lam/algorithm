package com.thare.algorithm.archive.lintcode.construct_binary_tree_from_preorder_and_inorder_traversal;

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
     * @param preorder : A list of integers that preorder traversal of a tree
     * @param inorder  : A list of integers that inorder traversal of a tree
     * @return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder, inorder, 0, 0, preorder.length - 1);
    }

    private TreeNode recursion(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int mid = indexOf(inorder, inStart, inEnd, preorder[preIndex]);
        if (mid >= 0) {
            root.left = recursion(preorder, inorder, preIndex + 1, inStart, mid - 1);
            root.right = recursion(preorder, inorder, mid - inStart + preIndex + 1, mid + 1, inEnd);
        }
        return root;
    }

    private int indexOf(int[] nums, int start, int end, int n) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == n) {
                return i;
            }
        }
        return -1;
    }

}
