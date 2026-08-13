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
    public ListNode detectCycle(ListNode head) {

        // Store visited nodes to detect repetition
        HashSet<ListNode> set = new HashSet<>();

        ListNode temp = head;

        while (temp != null) {

            // If the node was already visited, it is the cycle's start
            if (set.contains(temp)) {
                return temp;
            }

            set.add(temp);
            temp = temp.next;
        }

        // Reached the end, so there is no cycle
        return null;
    }
}