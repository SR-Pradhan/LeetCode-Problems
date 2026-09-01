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

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        // Find node at position a - 1
        ListNode beforeA = list1;

        for (int i = 0; i < a - 1; i++) {
            beforeA = beforeA.next;
        }

        // Find node at position b
        ListNode atB = beforeA;

        for (int i = a; i <= b; i++) {
            atB = atB.next;
        }

        // Connect node before a to list2
        beforeA.next = list2;

        // Find the last node of list2
        ListNode list2End = list2;

        while (list2End.next != null) {
            list2End = list2End.next;
        }

        // Connect list2 to node after b
        list2End.next = atB.next;

        return list1;
    }
}