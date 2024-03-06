class Solution {
    public int closedIsland(int[][] grid) 
    {
        int row=grid.length;
        int col=grid[0].length;

        int count=0;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==0 && dfs(grid,i,j))
                {
                    count++;
                }
            }
        }

        return count;
    }
    public boolean dfs(int[][] grid,int i,int j)
    {
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1)
        {
            return false;
        }

        if(grid[i][j]==1) return true;


        grid[i][j]=1;

        boolean down=dfs(grid, i + 1, j);
        boolean up=dfs(grid, i - 1, j);
        boolean right=dfs(grid, i, j + 1);
        boolean left=dfs(grid, i, j - 1);

        return down && right && up && left; 
        
    }
}