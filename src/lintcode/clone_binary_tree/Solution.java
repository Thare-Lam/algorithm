package lintcode.clone_binary_tree;

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
     * @param root: The root of binary tree
     * @return root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        return clone(root);
    }

    private TreeNode clone(TreeNode node) {
        if (node != null) {
            TreeNode cloneNode = new TreeNode(node.val);
            cloneNode.left = clone(node.left);
            cloneNode.right = clone(node.right);
            return cloneNode;
        }
        return null;
    }
}
