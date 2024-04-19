class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length==1) return nums[0];

        int n=nums.length;

        return helper(nums,n);
        
    }
    public int helper(int[] nums,int n)
    {
    
        int[] dp=new int[n];

        dp[0]=nums[0];
        dp[1]=nums[1];
        
        if(nums.length>2)
        {
            dp[2]=nums[2]+nums[0];
        }
        

        for(int i=3;i<dp.length;i++)
        {
            dp[i]=nums[i]+Math.max(dp[i-2],dp[i-3]);
        }


        return Math.max(dp[n-1],dp[n-2]);
    }
}