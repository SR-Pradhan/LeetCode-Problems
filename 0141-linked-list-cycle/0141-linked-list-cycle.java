public class Solution {
    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {

            // If the current node was already visited, a cycle exists.
            if (set.contains(curr)) {
                return true;
            } else {
                // Store the current node as visited.
                set.add(curr);

                // Move to the next node.
                curr = curr.next;
            }
        }

        // Reached null, so there is no cycle.
        return false;
    }
}