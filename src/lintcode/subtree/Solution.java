package lintcode.subtree;

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Solution {
    /*
     * @param t1: The roots of binary tree t1.
     * @param t2: The roots of binary tree t2.
     * @return: True if t2 is a subtree of t1, or false.
     */
    public boolean isSubtree(TreeNode t1, TreeNode t2) {
        return t2 == null || judgeSubtree(t1, t2);
    }

    private boolean judgeSubtree(TreeNode root, TreeNode target) {
        boolean flag = false;
        if (root == null) {
            return false;
        } else if (root.val == target.val) {
            flag = isSame(root, target);
        }
        return flag || judgeSubtree(root.left, target) || judgeSubtree(root.right, target);
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b != null) {
            if (a.val != b.val) {
                return false;
            } else {
                return isSame(a.left, b.left) && isSame(a.right, b.right);
            }
        }
        return false;
    }
}
