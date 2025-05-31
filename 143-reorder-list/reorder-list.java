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

        ListNode curr=head;

        ListNode mid=middle(curr);
        ListNode rev=reverse(mid);

        ListNode curr1=curr;
        ListNode curr1_next=curr1.next;

        ListNode curr2=rev;
        ListNode curr2_next=curr2.next;

        while(curr1_next!=null && curr2_next!=null)
        {
            curr1.next=curr2;
            curr2.next=curr1_next;

            curr1=curr1_next;
            curr2=curr2_next;

            curr1_next=curr1_next.next;
            curr2_next=curr2_next.next;
        
        }
    
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }
    public ListNode middle(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
}