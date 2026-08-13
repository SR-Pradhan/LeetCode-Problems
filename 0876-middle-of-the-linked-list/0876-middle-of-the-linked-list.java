class Solution {
    public ListNode middleNode(ListNode head) {

        int count = 0;
        ListNode current = head;

        // Count the number of nodes.
        while (current != null) {
            count++;
            current = current.next;
        }

        // For even length, count / 2 gives the second middle.
        int middleIndex = count / 2;

        ListNode middle = head;

        // Move to the middle node.
        for (int i = 0; i < middleIndex; i++) {
            middle = middle.next;
        }

        return middle;
    }
}