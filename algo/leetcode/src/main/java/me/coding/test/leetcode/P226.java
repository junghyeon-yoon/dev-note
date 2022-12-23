package me.coding.test.leetcode;

import me.coding.test.leetcode.util.TreeNode;

public class P226 {
    // https://leetcode.com/problems/invert-binary-tree/
    public static void main(String[] args) {
        var problem = new P226();
        TreeNode head = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(problem.invertTree(head);
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
