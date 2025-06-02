class Solution 
{
    public boolean canJump(int[] nums) 
    {
        int final_idx=nums.length-1;

        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]>=final_idx-i)
            {
                final_idx=i;
            }
        }

        return final_idx==0;
    }
}