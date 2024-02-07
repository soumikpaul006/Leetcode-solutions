import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k)
    {
        PriorityQueue<BigInteger> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<nums.length;i++)
        {
            pq.add(new BigInteger(nums[i]));
        }

        while(k!=1)
        {
            k--;
            pq.remove();
        }

        return pq.peek().toString();
  
    }
}