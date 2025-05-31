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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode curr1=l1;
        ListNode curr2=l2;

        ListNode head=new ListNode(-1);
        ListNode curr=head;
        
        int rem=0;
    
        while(curr1!=null && curr2!=null)
        {
            int sum=curr1.val+curr2.val+rem;
            rem=sum/10;

            curr.next=new ListNode(sum%10);
            curr=curr.next;

            curr1=curr1.next;
            curr2=curr2.next;

        }

        while(curr1!=null)
        {   
            int sum=curr1.val+rem;
            rem=sum/10;
            curr.next=new ListNode(sum%10);
            curr1=curr1.next;
            curr=curr.next;
        }

        while(curr2!=null)
        {
            int sum=curr2.val+rem;
            rem=sum/10;
            curr.next=new ListNode(sum%10);
            curr2=curr2.next;
            curr=curr.next;
        }

        if(rem>0)
        {
            curr.next=new ListNode(rem);
        }

        return head.next;
    }
}