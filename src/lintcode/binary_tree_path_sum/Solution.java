package lintcode.binary_tree_path_sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> traceStack = new Stack<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int count = 0;
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                root = stack.peek();
                if (!traceStack.isEmpty() && root == traceStack.peek()) {
                    traceStack.pop();
                } else if (root.right != null) {
                    traceStack.push(root);
                    root = root.right;
                    continue;
                } else if (root.left == null && count == target) {
                    result.add(getList(stack));
                }
                count -= stack.pop().val;
                root = null;
            } else {
                stack.push(root);
                count += root.val;
                root = root.left;
            }
        }
        return result;
    }

    private List<Integer> getList(Stack<TreeNode> stack) {
        List<Integer> list = new ArrayList<Integer>();
        for (TreeNode node : stack) {
            list.add(node.val);
        }
        return list;
    }

}
