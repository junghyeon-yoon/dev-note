package me.leetcode.solution;

public class P234 {

    // https://leetcode.com/problems/palindrome-linked-list/
    public static void main(String[] args) {
        var problem = new P234();
        var nodeList = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));

        System.out.println(problem.isPalindrome(nodeList));
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
    public boolean isPalindrome(ListNode head) {
        var temp1 = new StringBuilder();
        var temp2 = new StringBuilder();
        var current = head;
        while(true) {
            temp1.append(current.val);
            temp2.append(current.val);
            current = current.next;
            if(current==null) {
                break;
            }
        }
        return temp1.compareTo(temp2.reverse())==0;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
