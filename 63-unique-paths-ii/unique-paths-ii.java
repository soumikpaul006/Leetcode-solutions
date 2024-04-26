class Solution 
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1) return 0;

        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }

        return helper(obstacleGrid,m-1,n-1,dp);
    }
    public int helper(int[][] obstacleGrid,int m,int n,int[][] dp)
    {
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;

        if(obstacleGrid[m][n]==1) return 0;

        if(dp[m][n]!=-1) return dp[m][n];

        int up=helper(obstacleGrid,m-1,n,dp);
        int left=helper(obstacleGrid,m,n-1,dp);

        return dp[m][n]=up+left;
    }
}