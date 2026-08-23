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
    public ListNode removeElements(ListNode head, int val) {

        // Dummy node handles the case where the head itself must be removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;

        while (temp.next != null) {

            // If the next node contains the target value, remove it
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                // Move forward only when no node is removed
                temp = temp.next;
            }
        }

        return dummy.next;
    }
}