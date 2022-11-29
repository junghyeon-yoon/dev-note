package me.leetcode.solution;

import java.util.Stack;

public class P2 {

    // https://leetcode.com/problems/add-two-numbers/
    public static void main(String[] args) {
        var problem = new P2();

        var l1 = new ListNode(1, new ListNode(6, new ListNode(0, new ListNode(3, new ListNode(3, new ListNode(6, new ListNode(7, new ListNode(2, new ListNode(0, new ListNode(1, null))))))))));
        var l2 = new ListNode(6, new ListNode(3, new ListNode(0, new ListNode(8, new ListNode(9, new ListNode(6, new ListNode(6, new ListNode(9, new ListNode(6, new ListNode(1, null))))))))));

        System.out.println(problem.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var isShiftNext = 0;
        var isShiftCurrent = 0;

        Stack<Integer> integers = new Stack<>();

        while(true) {
            if(l1==null && l2==null) {
                if(isShiftCurrent==1) {
                    integers.push(1);
                }
                break;
            }

            var num1 = l1!=null?l1.val:0;
            var num2 = l2!=null?l2.val:0;

            var newNum = num1 + num2 + isShiftCurrent;

            if(newNum==0 && l1!=null && l2!=null && l1.next==null && l2.next==null) {
                return new ListNode(0);
            }

            isShiftNext = newNum>=10?1:0;
            if(isShiftNext==1) {
                newNum = newNum-10;
            }

            integers.push(newNum);

            isShiftCurrent = isShiftNext;
            isShiftNext = 0;

            l1 = l1!=null?l1.next:null;
            l2 = l2!=null?l2.next:null;
        }

        ListNode result = null;

        while(!integers.empty()) {
            result = new ListNode(integers.pop(), result);
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
