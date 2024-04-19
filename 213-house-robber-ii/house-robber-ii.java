class Solution 
{
    public int rob(int[] nums) 
    {
        if(nums.length==1) return nums[0];

        int n=nums.length;

        int[] dp1=new int[n];
        Arrays.fill(dp1,-1);

        int[] dp2=new int[n];
        Arrays.fill(dp2,-1);
        

        return Math.max(helper(nums,0,n-2,dp1),helper(nums,1,n-1,dp2));
        
    }
    public int helper(int[] nums,int start,int end,int[] dp)
    {
        if(end<start) return 0;

        if(dp[end]!=-1) return dp[end];

        int if_rob=nums[end]+helper(nums,start,end-2,dp);

        int not_rob=helper(nums,start,end-1,dp);

        return dp[end]=Math.max(if_rob,not_rob);
    }
}