/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            // Move slow one step and fast two steps.
            slow = slow.next;
            fast = fast.next.next;

            // If both pointers meet, a cycle exists.
            if (slow == fast) {
                return true;
            }
        }

        // Fast reached the end, so there is no cycle.
        return false;
    }
}