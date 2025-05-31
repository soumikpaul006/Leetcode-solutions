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

        
        ListNode curr=head;

        ListNode mid=middle(curr);
        ListNode rev=reverse(mid);


        while(curr!=null && rev!=null)
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