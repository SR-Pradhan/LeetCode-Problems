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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Handle cases where one or both lists are empty
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head;

        // Choose the smaller first node as the head
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        // temp always points to the last node of the merged list
        ListNode temp = head;

        // Compare nodes while both lists still have elements
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }

            // Move temp to the newly attached node
            temp = temp.next;
        }

        // Attach the remaining nodes of the non-empty list
        if (list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }

        return head;
    }
}