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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;//connect dummy to head
        ListNode previousgroup = dummy;//the starting grp
        while(true){
            ListNode kthnode = previousgroup;
            for(int i = 0;kthnode != null && i < k;i++){
                kthnode = kthnode.next;
            }
            if(kthnode == null){
                break;//no need to reverse
            }
            ListNode nextgroup = kthnode.next;//new group
            ListNode current = previousgroup.next;
            ListNode previous = nextgroup;//since we need to connect to new one
            while(current != nextgroup){
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            ListNode newgroup = previousgroup.next;
            previousgroup.next = kthnode;//connect to kthnode
            previousgroup = newgroup;
        }
        return dummy.next;
    }
}
