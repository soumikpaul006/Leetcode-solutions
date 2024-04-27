class Solution 
{
    public int minPathSum(int[][] grid) 
    {
        int m=grid.length;
        int n=grid[0].length;

        

        return helper(grid,m,n);        
    }
    public int helper(int[][] grid,int m,int n)
    {

        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                {
                    dp[0][0]=grid[0][0];
                } 
                else{
                    // int up=grid[i][j];
                    // int left=grid[i][j];

                    int up=0;
                    int left=0;


                    if(i>0)
                    {
                        up+=dp[i-1][j];
                    }
                    else{
                        up+=1e9;
                    }
                    
                    if(j>0)
                    {
                        left+=dp[i][j-1];
                    }
                    else{
                        left+=1e9;
                    }

                    dp[i][j]=Math.min(up,left)+grid[i][j];
                }
            }
        }

        return dp[m-1][n-1];

    }
}