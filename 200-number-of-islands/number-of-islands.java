class Solution 
{
    
    public int numIslands(char[][] grid) 
    {
        int row=grid.length;
        int col=grid[0].length;

        int noOfIsland=0;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='1')
                {
                    noOfIsland++;
                    dfs(grid,i,j);
                }
            }
        }

        return noOfIsland;   
    }
    public void dfs(char[][] grid,int i,int j)
    {
        //base
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]!='1')
        {
            return;
        }

        grid[i][j]='2';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}