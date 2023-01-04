package me.coding.test.leetcode.medium;

import me.coding.test.leetcode.util.ListNode;

public class P19 {
    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    public static void main(String[] args) {
        var problem = new P19();
//        ListNode listNode = new ListNode(1, null);
//        System.out.println(problem.removeNthFromEnd(listNode, 1));

        ListNode listNode = new ListNode(1, new ListNode(2, null));
        System.out.println(problem.removeNthFromEnd(listNode, 2));

//        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
//        System.out.println(problem.removeNthFromEnd(listNode, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) {
            return null;
        }

        ListNode first = new ListNode(0, head);
        ListNode front = first;
        ListNode back = first;

        while(n>0) {
            front = front.next;
            n--;
        }

        while(front.next!=null) {
            back = back.next;
            front = front.next;
        }

        back.next = back.next.next;

        return first.next;
    }
}
