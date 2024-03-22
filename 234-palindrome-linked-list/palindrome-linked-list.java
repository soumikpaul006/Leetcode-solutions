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
class Solution 
{
    public boolean isPalindrome(ListNode head) 
    {   

        if(head==null || head.next==null) return true;

        // ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;

        //find middle
        while(fast!=null && fast.next!=null)
        {
            // prev=slow; 
            slow=slow.next;
            fast=fast.next.next;
        }

        // prev.next=null;

        ListNode rev=reverse(slow);

        ListNode curr=head;

        while(rev!=null && curr!=null)
        {
            if(curr.val!=rev.val)
            {
                return false;
            }
            curr=curr.next;
            rev=rev.next;
        }

        return true;   
    }
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
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

    
}