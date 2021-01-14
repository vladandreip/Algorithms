package com.company;

/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
public class MergeTwoSortedLists21 {
    public static void main(String[] args) {

    }

    /**
     *Faster that 100%
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode solution;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if(l1.val < l2.val) {
            solution = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            solution = new ListNode(l2.val);
            l2 = l2.next;
        }

        head = solution;

        do {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    solution.next = new ListNode(l1.val);
                    solution = solution.next;
                    l1 = l1.next;
                } else {
                    solution.next = new ListNode(l2.val);
                    solution = solution.next;
                    l2 = l2.next;
                }
            }

            if(l1 == null) {
                solution.next = l2;
            } else {
                solution.next = l1;
            }

            if(l2 == null) {
                solution.next = l1;
            } else {
                solution.next = l2;
            }

        } while(l1 != null && l2 != null);

        return head;
    }
}