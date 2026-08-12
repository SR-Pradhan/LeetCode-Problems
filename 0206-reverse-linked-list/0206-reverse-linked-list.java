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
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            // Save the next node before changing the link.
            ListNode nextNode = curr.next;

            // Reverse the current node's pointer.
            curr.next = prev;

            // Move previous and current one step forward.
            prev = curr;
            curr = nextNode;
        }

        // Previous becomes the new head.
        return prev;
    }
}