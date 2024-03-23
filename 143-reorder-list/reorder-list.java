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
    public void reorderList(ListNode head) 
    {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode right=reverse(slow);
        ListNode right_next=right.next;

        ListNode left=head;
        ListNode left_next=left.next;


        while(left_next!=null && right_next!=null)
        {
            left.next=right;
            left=left_next;
            right.next=left;
            left_next=left_next.next;
            right=right_next;
            right_next=right_next.next;
        }
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode next=head;
        ListNode curr=head;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

}