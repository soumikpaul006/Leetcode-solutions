class Solution {
    public int maxSubArray(int[] nums) 
    {
        if(nums.length==1) return nums[0];

        int totalMax=nums[0];
        int max=nums[0]; 

        for(int i=1;i<nums.length;i++)
        {   
            if(nums[i]<nums[i]+max)
            {
                max=nums[i]+max;
            }
            else{
                max=nums[i];
            }

            totalMax=Math.max(totalMax,max);
        }

        return totalMax;
    }
}