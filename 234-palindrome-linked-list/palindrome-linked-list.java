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

        if(head.next==null)
        {
            return true;
        }

        ListNode slow=head;
        ListNode fast=head;

        // Step 1: Find the middle of the list using slow and fast pointers
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        // Step 2: Reverse the second half of the list starting from 'slow'
        ListNode rev=reverse(slow);

        ListNode curr=head;

        // Step 3: Compare the first half (head to slow) with the reversed second half
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
}