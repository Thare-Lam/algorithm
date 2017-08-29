package lintcode.binary_tree_serialization;

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
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                append(sb, null);
                root = stack.pop();
                root = root.right;
            } else {
                append(sb, root.val);
                stack.push(root);
                root = root.left;
            }
        }
        return sb.toString().substring(0, sb.length() - 3);
    }

    private void append(StringBuilder sb, Integer value) {
        if (value == null) {
            sb.append("#");
        } else {
            sb.append(value);
        }
        sb.append(",");
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        int i;
        String[] list = data.split(",");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(Integer.valueOf(list[0]));
        TreeNode pre = root;
        for (i = 1; i < list.length; ++i) {
            TreeNode node = getNode(list[i]);
            if (pre == null) {
                pre = stack.peek();
            }
            if (!stack.isEmpty() && stack.peek() == pre) {
                pre.right = node;
                stack.pop();
            } else {
                pre.left = node;
                stack.push(pre);
            }
            pre = node;
        }
        return root;
    }

    private TreeNode getNode(String value) {
        return value.equals("#") ? null : new TreeNode(Integer.valueOf(value));
    }
}
