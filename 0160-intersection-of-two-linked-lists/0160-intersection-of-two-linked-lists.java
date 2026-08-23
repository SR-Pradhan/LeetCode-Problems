class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();

        // Store all nodes of List A in the HashSet
        ListNode temp = headA;

        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }

        // Traverse List B and check for a common node
        temp = headB;

        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }
}