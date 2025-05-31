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
    public ListNode sortList(ListNode head) 
    {
        if(head==null || head.next==null) return head;

        ListNode curr=head;

        ListNode mid = middle(curr);
        ListNode left = sortList(curr);
        ListNode right = sortList(mid);

        return merge(left,right); 
    }
    public ListNode merge(ListNode curr1,ListNode curr2)
    {
        ListNode l1=curr1;
        ListNode l2=curr2;

        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;

        while(l1!=null && l2!=null)
        {   
            if(l1.val<l2.val)
            {   
                curr.next=new ListNode(l1.val);
                l1=l1.next;
            }
            else{
                curr.next=new ListNode(l2.val);
                l2=l2.next;
            }

            curr=curr.next;

        }

        while(l1!=null)
        {
            curr.next=new ListNode(l1.val);
            l1=l1.next;
            curr=curr.next;
        }

        while(l2!=null)
        {
            curr.next=new ListNode(l2.val);
            l2=l2.next;
            curr=curr.next;
        }

        return dummy.next;

    }
    public ListNode middle(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;

        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=null;

        return slow;
    }
}
