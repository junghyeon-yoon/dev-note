package me.coding.test.leetcode.easy;

import me.coding.test.leetcode.util.TreeNode;

public class P543 {
    // https://leetcode.com/problems/diameter-of-binary-tree/
    public static void main(String[] args) {
        var problem = new P543();
        TreeNode node_2 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode head = new TreeNode(1, node_2, new TreeNode(3));
        System.out.println(problem.diameterOfBinaryTree(head));
    }

    int longestDistance = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        inOrder(root);

        return longestDistance;
    }

    public int inOrder(TreeNode node) {
        if(node==null) {
            return 0;
        }

        int left = inOrder(node.left);
        int right = inOrder(node.right);
        

        int distance = left + right;
        longestDistance = Math.max(longestDistance, distance);
        
        return Math.max(left, right)+1;
    }
}
