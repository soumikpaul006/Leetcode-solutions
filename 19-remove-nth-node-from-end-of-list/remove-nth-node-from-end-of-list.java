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
        if(head.next==null && n==1) return null;

        ListNode curr=head;
        int len=0;

        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }

        int idx=len-n-1; //3

        if(idx<0) return head.next;

        ListNode curr1=head;

        while(idx>0)
        {
            idx--;
            curr1=curr1.next;
        }

        curr1.next=curr1.next.next;

        return head;
    }
}