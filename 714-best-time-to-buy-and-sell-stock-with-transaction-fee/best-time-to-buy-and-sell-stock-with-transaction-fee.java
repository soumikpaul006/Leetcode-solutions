class Solution {
    public int maxProfit(int[] prices, int fee) 
    {
        int n=prices.length;
        int[][] dp = new int[prices.length+1][2]; // 2 states: 0 for holding, 1 for not holding

        dp[n][0]=0;
        dp[n][1]=0;

        int profit=0;

        for(int idx=n-1;idx>=0;idx--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                if (buy == 1) 
                {
                    // Buy or do not buy
                    profit = Math.max(-prices[idx] + dp[idx + 1][0], // buy
                                    0 + dp[idx + 1][1]); // do not buy
                } else {
                    // Sell or do not sell
                    profit = Math.max(prices[idx] + dp[idx + 1][1]-fee, // sell
                                    0 + dp[idx + 1][0]); // do not sell
                }
                dp[idx][buy]=profit;
            }
            
        }

        return dp[0][1]; 
        
    }
}