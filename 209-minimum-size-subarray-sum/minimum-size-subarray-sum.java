class Solution 
{
    public int minSubArrayLen(int target, int[] nums) 
    {
        int start=0;
        int end=0;

        int ans=Integer.MAX_VALUE;
        int sum=0;

        while(end<nums.length)
        {
            sum+=nums[end];

            while(sum>=target)
            {
                ans=Math.min(ans,end-start+1);
                sum-=nums[start];
                start++;
            }
            end++;
        }

        return ans==Integer.MAX_VALUE?0:ans;
        
    }
}