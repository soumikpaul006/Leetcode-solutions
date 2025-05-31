class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int[][] dp=new int[prices.length][2];

        for(int i=0;i<dp.length;i++)
        {
            dp[i][0]=-1;
            dp[i][1]=-1;
        }

        return func(prices,0,1,dp); 
    }
    public int func(int[] prices,int idx,int buy, int[][] dp)
    {
        if(idx==prices.length)
        {
            return 0;
        }

        if(dp[idx][buy]!=-1)
        {
            return dp[idx][buy];
        } 

        int profit=0;

        if(buy==1)
        {
            profit=Math.max((-prices[idx]+func(prices,idx+1,0,dp)) //buy
            ,(0+func(prices,idx+1,1,dp)));//not buy
        }
        else{
            profit=Math.max((prices[idx]+func(prices,idx+1,1,dp)), //sell
            (0+func(prices,idx+1,0,dp)));//not sell
        }
        
       return dp[idx][buy]=profit;
    }
}