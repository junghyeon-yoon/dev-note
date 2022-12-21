package me.coding.test.leetcode;

import me.coding.test.leetcode.util.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class P21 {
    // https://leetcode.com/problems/merge-two-sorted-lists/
    public static void main(String[] args) {
        var problem = new P21();
//        var nodeList11 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
//        var nodeList12 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        var nodeList11 = new ListNode(2, null);
        var nodeList12 = new ListNode(1, null);

        ListNode listNode = problem.mergeTwoLists(nodeList11, nodeList12);

        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
            if(listNode!=null) {
                System.out.print(", ");
            }
        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        Queue<ListNode> queue = new LinkedList<>();

        while(list1!=null || list2!=null) {
            if(list1!=null && list2==null) {
                queue.add(list1);
                list1 = list1.next;
            } else if(list1==null && list2!=null) {
                queue.add(list2);
                list2 = list2.next;
            } else {
                if(list1.val == list2.val) {
                    queue.add(list1);
                    queue.add(list2);
                    list1 = list1.next;
                    list2 = list2.next;
                } else if (list1.val < list2.val) {
                    queue.add(list1);
                    list1 = list1.next;
                } else {
                    queue.add(list2);
                    list2 = list2.next;
                }
            }
        }

        if(queue.isEmpty()) {
            return null;
        } else {
            return getListNode(queue);
        }
    }

    private ListNode getListNode(Queue<ListNode> queue) {
        if(queue.isEmpty()) {
            return null;
        } else {
            ListNode popNode = queue.poll();
            popNode.next = getListNode(queue);
            return popNode;
        }
    }
}
