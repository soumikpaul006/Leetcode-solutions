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
    public ListNode removeZeroSumSublists(ListNode head)
    {
        
        
        HashMap<Integer, ListNode> map = new HashMap<>();
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        map.put(0, dummy);                                    
        
        ListNode curr = head;

        int prefixSum = 0;
        
        while(curr!=null){
            
            prefixSum += curr.val;
            
            if(map.containsKey(prefixSum))
            {
                
                ListNode n1 = map.get(prefixSum);          
                
                ListNode n1_next = n1.next;         
                int removeSum = prefixSum;

                while(n1_next != curr)
                {
                    removeSum = removeSum + n1_next.val;
                    map.remove(removeSum);
                    n1_next = n1_next.next;
                }
                n1.next = curr.next;                    
            }
            else
            {
                map.put(prefixSum, curr);
            }
            
            curr = curr.next;
        }
        
        return dummy.next;
    }
}