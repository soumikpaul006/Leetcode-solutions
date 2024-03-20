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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) 
    {
        ListNode curr1=list1;
        int count1=0;
        int count2=0;

        while(count1!=a-1)
        {
            curr1=curr1.next;
            count1++;
        }
        
        ListNode curr2=list1;
        while(count2!=b+1)
        {
            curr2=curr2.next;
            count2++;
        }

        ListNode curr=list2;
        while(curr.next!=null)
        {
            curr=curr.next;
        }

        curr1.next=list2;
        curr.next=curr2;

        return list1;


        
    }
}