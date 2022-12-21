package me.coding.test.leetcode;

import java.util.Stack;

public class P876 {

    // https://leetcode.com/problems/palindrome-linked-list/
    public static void main(String[] args) {
        var problem = new P876();
        System.out.println(
                problem.middleNode(
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))))
                ).val
        );

        System.out.println(
                problem.middleNode(
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))))
                ).val
        );

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode middleNode(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        do {
            stack.push(head);
            head = head.next;
        } while(head!=null);

        var targetIndex = stack.size()/2;
        return stack.elementAt(targetIndex);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
