package me.coding.test.leetcode.easy;

import me.coding.test.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P114 {
    // https://leetcode.com/problems/binary-tree-preorder-traversal/

    public static void main(String[] args) {
        var problem = new P114();
        TreeNode rootNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(problem.preorderTraversal(rootNode));
    }

    List<Integer> visit = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);

        return visit;
    }

    public void preOrder(TreeNode node) {
        if(node==null) {
            return;
        }

        visit.add(node.val); //visit

        preOrder(node.left);
        preOrder(node.right);
    }
}
