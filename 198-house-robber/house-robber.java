class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length==1) return nums[0];
        int n=nums.length;

        int[] dp=new int[n];

        Arrays.fill(dp,-1);

        return Math.max(helper(nums,n-1,dp),helper(nums,n-2,dp));
        
    }
    public int helper(int[] nums,int n,int[] dp)
    {
        if(n==0||n==1)
        {
            return nums[n];
        }
        
        if(n==2)
        {
            return nums[2]+nums[0];
        }

        if(dp[n]!=-1) return dp[n];
        


        return dp[n]=nums[n]+Math.max(helper(nums,n-2,dp),helper(nums,n-3,dp));
    }
}