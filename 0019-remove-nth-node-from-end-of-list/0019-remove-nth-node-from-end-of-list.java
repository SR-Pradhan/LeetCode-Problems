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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;
        int len = 0;

        // Find the length of the linked list
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        // Position of the node before the target node
        int node = len - n;

        // If the head itself needs to be removed
        if (node == 0) {
            head = head.next;
            return head;
        }

        temp = head;
        int count = 1;

        // Find the node before the target and skip the target
        while (temp != null) {

            if (node == count) {
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
            count++;
        }

        return head;
    }
}