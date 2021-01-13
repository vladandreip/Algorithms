package com.company;

import java.util.LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overflow = 0;
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode result = head;
        ListNode nodeResult;
        ListNode node1 = null;
        ListNode node2 = null;

        if (l1.next != null) {
            node1 = l1.next;
        }

        if (l2.next != null) {
            node2 = l2.next;
        }


        overflow = (l1.val + l2.val) / 10;

        if (overflow > 0) {
            result.next = new ListNode(overflow);
        }

        while (node1 != null || node2 != null) {
            if (node1 != null) {
                overflow += node1.val;
                node1 = node1.next;
            }

            if (node2 != null) {
                overflow += node2.val;
                node2 = node2.next;
            }



            if (result.next != null) {
                result = result.next;
                result.val = overflow % 10;
            } else {
                result.next = new ListNode(overflow % 10);
                result = result.next;
            }


            if (overflow / 10 > 0) {
                result.next = new ListNode(overflow / 10);
            }

            overflow = overflow / 10;
        }

        return head;
    }



}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
