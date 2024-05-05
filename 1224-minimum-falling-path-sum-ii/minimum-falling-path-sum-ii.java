class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        // Copy the last row of the grid to the dp array
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = grid[n - 1][i];
        }

        // Iterate over each row starting from the second last row
        for (int i = n - 2; i >= 0; i--) 
        {
            for (int j = 0; j < n; j++) 
            {
                // Initialize the minimum value for this cell to be Integer.MAX_VALUE
                int minVal = Integer.MAX_VALUE;

                // Iterate over each column in the next row
                for (int k = 0; k < n; k++) 
                {
                    // Skip if the column index is the same as the current column index
                    if (j != k) 
                    {
                        // Update the minimum value for this cell based on the next row's value
                        minVal = Math.min(minVal, dp[i + 1][k]);
                    }
                }

                // Update the current cell's value with the minimum value found plus the current cell's value
                dp[i][j] = minVal + grid[i][j];
            }
        }

        // Find the minimum value in the first row of the dp array
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dp[0][i]);
        }

        return minSum;
    }
}
