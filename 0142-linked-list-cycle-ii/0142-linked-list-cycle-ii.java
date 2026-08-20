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
        ListNode temp = head;

        HashSet<ListNode> set = new HashSet<>();

        while(temp != null){
            if(set.contains(temp)) return temp;
            else set.add(temp);

            temp = temp.next;
        }  
        return null; 
    }
}