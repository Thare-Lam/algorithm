package lintcode.construct_binary_tree_from_inorder_and_postorder_traversal;

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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recursion(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode recursion(int[] postorder, int[] inorder, int postIndex, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        int mid = indexOf(inorder, inStart, inEnd, postorder[postIndex]);
        if (mid >= 0) {
            root.left = recursion(postorder, inorder, postIndex - (inEnd - mid) - 1, inStart, mid - 1);
            root.right = recursion(postorder, inorder, postIndex - 1, mid + 1, inEnd);
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
