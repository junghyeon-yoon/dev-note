package me.coding.test.leetcode;

import me.coding.test.leetcode.util.TreeNode;

import java.util.*;

public class P94 {
    // https://leetcode.com/problems/climbing-stairs/

    public static void main(String[] args) {
        var problem = new P94();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        System.out.println(problem.inorderTraversal(node1));
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        if(root==null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        TreeNode node = root;

        while(true) {
            if(!visited.contains(node)) {
                if(node.left!=null && !visited.contains(node.left)) {
                    stack.push(node);
                    node = node.left;
                } else {
                    visited.add(node);
                    list.add(node.val);
                }
            } else {
                if(node.right!=null) {
                    node = node.right;
                } else {
                    if(stack.isEmpty()) {
                        break;
                    } else {
                        node = stack.pop();
                    }
                }
            }
        }

        return list;
    }
}
