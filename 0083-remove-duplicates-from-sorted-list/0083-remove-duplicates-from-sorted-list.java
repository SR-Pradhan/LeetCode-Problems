class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            // If two adjacent nodes have the same value, skip the duplicate
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                // Move forward only when no duplicate is found
                curr = curr.next;
            }
        }

        return head;
    }
}