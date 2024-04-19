class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length==1) return nums[0];

        int n=nums.length;

        int[] dp=new int[n];

        Arrays.fill(dp,-1);

    
        return helper(nums,n-1,dp);
    }
    public int helper(int[] nums,int n,int[] dp)
    {
        if(n<0)
        {
            return 0;
        }

        if(dp[n]!=-1) return dp[n];
        
        int if_rob=nums[n]+helper(nums,n-2,dp);

        int not_rob=helper(nums,n-1,dp);

        return dp[n]=Math.max(if_rob,not_rob);
    
    }
}