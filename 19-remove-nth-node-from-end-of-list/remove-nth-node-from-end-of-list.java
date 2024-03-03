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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if( n==1 && head.next==null) return null;

        int len=findLen(head);
        int step=len-n-1;

        if(step<0) return head.next;

        ListNode curr1=head;

        while(step>0)
        {
            step--;

            curr1=curr1.next;

        }

        curr1.next=curr1.next.next;

        return head; 

    }
    public int findLen(ListNode head)
    {
        ListNode curr=head;
        int len=0;

        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }

        return len;
    }
}