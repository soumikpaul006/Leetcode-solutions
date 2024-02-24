class Solution 
{   
   
    public int maxAreaOfIsland(int[][] grid) 
    {
        int row=grid.length;
        int col=grid[0].length;
        int ans=0; 
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==1)
                {
                    int sum=dfs(grid,i,j,0);   
                    ans=Math.max(ans,sum);
                }
            }
        }
    
        return ans;
    }
    public int dfs(int[][] grid,int i,int j,int sum)
    {

        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]!=1)
        {
            return sum;
        }

        sum=sum+1;
        
        grid[i][j]=2;

        sum=dfs(grid,i+1,j,sum);
        sum=dfs(grid,i-1,j,sum);
        sum=dfs(grid,i,j+1,sum);
        sum=dfs(grid,i,j-1,sum);

        return sum;

    }
}