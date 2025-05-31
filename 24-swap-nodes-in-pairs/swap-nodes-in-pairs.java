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
    public ListNode swapPairs(ListNode head) 
    {
        if(head==null || head.next==null) return head;

        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode curr=dummy;


        while(curr.next!=null && curr.next.next!=null)
        {
            ListNode ptr1=curr.next;
            ListNode ptr2=curr.next.next;

            ptr1.next=ptr2.next;
            ptr2.next=ptr1;
            curr.next=ptr2;

            curr=ptr1;

        }

        return dummy.next;
        
    }
}