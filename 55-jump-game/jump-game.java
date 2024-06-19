class Solution 
{
    public boolean canJump(int[] nums) 
    {
        int finalIdx=nums.length-1;

        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]>=finalIdx-i)
            {
                finalIdx=i;
            }
        }

        return finalIdx==0;
    }
}