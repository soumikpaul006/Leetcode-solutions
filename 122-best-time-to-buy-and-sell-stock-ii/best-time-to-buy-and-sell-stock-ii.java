class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2]; // 2 states: 0 for holding, 1 for not holding

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return func(prices, 0, 1, dp); // Starting with index 0 and buy allowed
    }

    public int func(int[] prices, int idx, int buy, int[][] dp) {
        // base case
        if (idx == prices.length) {
            return 0;
        }

        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        int profit = 0;
        if (buy == 1) {
            // Buy or do not buy
            profit = Math.max(-prices[idx] + func(prices, idx + 1, 0, dp), // buy
                              0 + func(prices, idx + 1, 1, dp)); // do not buy
        } else {
            // Sell or do not sell
            profit = Math.max(prices[idx] + func(prices, idx + 1, 1, dp), // sell
                              0 + func(prices, idx + 1, 0, dp)); // do not sell
        }

        dp[idx][buy] = profit;
        return dp[idx][buy];
    }
}
