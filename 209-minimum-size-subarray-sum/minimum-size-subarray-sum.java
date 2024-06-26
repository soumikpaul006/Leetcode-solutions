class Solution 
{
    public int minSubArrayLen(int target, int[] nums) 
    {
        int sum=0;
        int i=0;
        int j=0;

        int min=Integer.MAX_VALUE;

        while(j<nums.length)
        {
            sum+=nums[j++];

            while(sum>=target)
            {
                min=Math.min(min,j-i);
                sum-=nums[i++];
            }
   
        }

        return min==Integer.MAX_VALUE?0:min;
    }
}