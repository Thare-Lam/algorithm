package nowcoder.coding_interviews._8b3b95850edb4115918ecebdf1b4d222;

import nowcoder.coding_interviews.helper.TreeNode;

public class Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        int[] info = getHeightAndBalance(root);
        return info[1] == 1;
    }

    private int[] getHeightAndBalance(TreeNode root) {
        if (root == null) {
            return new int[]{0, 1};
        }
        int[] left = getHeightAndBalance(root.left);
        int[] right = getHeightAndBalance(root.right);
        int[] res = new int[2];
        if (left[1] == 1 && right[1] == 1 && Math.abs(left[0] - right[0]) < 2) {
            res[0] = Math.max(left[0], right[0]) + 1;
            res[1] = 1;
        }
        return res;
    }
}
