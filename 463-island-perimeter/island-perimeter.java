class Solution 
{
    public int count=0;
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
        
        return count;
    }   
    public void dfs(int[][] grid,int i,int j)
    {   
        //base
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]==0)
        {
            count++;
            return;
        }
        if(grid[i][j]==2) return;

        grid[i][j]=2;

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}