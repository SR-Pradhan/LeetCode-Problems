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
    public int getDecimalValue(ListNode head) {

        ListNode temp = head;
        int number = 0;

        while (temp != null) {

            // Shift existing bits left and add the current bit
            number = number * 2 + temp.val;

            temp = temp.next;
        }

        return number;
    }
}