class Solution 
{
    int ans=0;
    public int islandPerimeter(int[][] grid) 
    {
        int row=grid.length;
        int col=grid[0].length;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==1)
                {
                    dfs(grid,i,j);
                }
            }
        }

        return ans;
    }   
    public void dfs(int[][] grid,int i,int j)
    {
        //base
        if(i>grid.length-1||i<0||j>grid[0].length-1||j<0||grid[i][j]==0)
        {
            ans++;
            return;
        }

        if(grid[i][j]==-1) return;

        grid[i][j]=-1;

        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
}