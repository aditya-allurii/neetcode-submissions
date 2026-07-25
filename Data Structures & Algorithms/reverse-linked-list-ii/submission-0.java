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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        for(int i = 1;i < left;i++){
            prev = current;
            current = current.next;
        }
        ListNode last = prev;
        ListNode newEnd = current;

        for(int i = 0;i < right - left + 1;i++){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if(last != null){
            last.next = prev;
        }else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }
}