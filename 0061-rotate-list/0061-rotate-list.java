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
        int len = 0;
        ListNode temp = head;
        ListNode tail = head;


        while(temp != null){
            if(temp.next == null){
                tail = temp;
            }
            temp = temp.next;
            len++;
        }

        if (head == null) {
           return head;
        }

        k = k % len;
        if(k == 0) return head;

        ListNode newTail = head;
        int newTailPosn = len - k;

        for(int i = 1; i < newTailPosn; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;


        tail.next = head;

        return newHead;        
    }
}