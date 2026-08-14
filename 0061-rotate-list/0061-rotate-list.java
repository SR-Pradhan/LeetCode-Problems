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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode temp = head;
        ListNode tail = head;
        int count = 0;

        // Find the length and the last node
        while (temp != null) {

            if (temp.next == null) {
                tail = temp;
            }

            temp = temp.next;
            count++;
        }

        // Reduce unnecessary full rotations
        k = k % count;

        if (k == 0) {
            return head;
        }

        // Find the new tail: (count - k)th node
        ListNode newTail = head;
        int newTailPosition = count - k;

        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        // The node after newTail becomes the new head
        ListNode newHead = newTail.next;

        // Break the list at newTail
        newTail.next = null;

        // Connect the old tail to the old head
        tail.next = head;

        return newHead;
    }
}