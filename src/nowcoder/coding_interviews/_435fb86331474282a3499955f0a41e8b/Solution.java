package nowcoder.coding_interviews._435fb86331474282a3499955f0a41e8b;

import nowcoder.coding_interviews.helper.TreeNode;
import java.util.*;

public class Solution {

    public int TreeDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = null;
        TreeNode nlast = null;
        if (root != null) {
            queue.add(root);
            last = root;
        }
        int height = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == last) {
                ++height;
            }
            if (cur.left != null) {
                queue.add(cur.left);
                nlast = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nlast = cur.right;
            }
            if (cur == last) {
                last = nlast;
            }
        }
        return height;
    }

}
