class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        int n=cost.length;
        int[] dp=new int[n+1];

        Arrays.fill(dp,-1);

        return Math.min(helper(cost,n-1,dp),helper(cost,n-2,dp));

    }
    public int helper(int[] cost,int n,int[] dp)
    {
        //base
        if(n==0 || n==1) return cost[n];

        if(dp[n]!=-1) return dp[n];
        
        //recurrence equation

        return dp[n]=cost[n]+Math.min(helper(cost,n-1,dp),helper(cost,n-2,dp));
    
    }
}