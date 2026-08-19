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
    public ListNode partition(ListNode head, int x) {

        // Dummy nodes for the two partitions
        ListNode lessDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        // Tail pointers for both partitions
        ListNode lessTail = lessDummy;
        ListNode largeTail = largeDummy;

        ListNode curr = head;

        while (curr != null) {

            // Save the next node before changing curr.next
            ListNode next = curr.next;

            if (curr.val < x) {
                lessTail.next = curr;
                lessTail = lessTail.next;
            } else {
                largeTail.next = curr;
                largeTail = largeTail.next;
            }

            // Move to the next node in the original list
            curr = next;
        }

        // End the larger/equal partition
        largeTail.next = null;

        // Connect the smaller partition to the larger/equal partition
        lessTail.next = largeDummy.next;

        // Return the first real node of the smaller partition
        return lessDummy.next;
    }
}