class Solution {
    public int minOperations(int[] nums, int k) 
    {
        PriorityQueue<Long> pq=new PriorityQueue<>();//min heap

        for(int i=0;i<nums.length;i++)
        {
            pq.add((long)nums[i]);
        }

        int count=0;

        while(pq.size()>=2 && pq.peek()<k )
        {
            long x=pq.remove();
            long y=pq.remove();

            pq.add((long)(x*2+y));

            count++;

        }

        return count;    
    }
}