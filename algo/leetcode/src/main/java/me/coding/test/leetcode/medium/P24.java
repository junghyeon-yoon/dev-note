package me.coding.test.leetcode.medium;

import me.coding.test.leetcode.util.ListNode;

import java.util.Stack;

public class P24 {
    // https://leetcode.com/problems/swap-nodes-in-pairs/
    public static void main(String[] args) {
        
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        
        var problem = new P24();
        System.out.println(problem.swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {

        if(head == null) {
            return head;
        }

        if(head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();

        while(head!=null) {
            stack.push(head);
            head = head.next;
        }

        if(stack.size()%2==1) {
            ListNode node = stack.pop();
            node.next = null;
            head = node;
        }
        
        while(!stack.isEmpty()) {
            ListNode nodeBack = stack.pop();
            ListNode nodeFront = stack.pop();

            nodeBack.next = nodeFront;
            nodeFront.next = head;
            head = nodeBack;
        }

        return head;
        
    }
}
