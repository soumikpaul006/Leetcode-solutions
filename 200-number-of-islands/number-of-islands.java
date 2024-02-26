class Solution 
{
    public int numIslands(char[][] grid) 
    {
        int count=0;
        boolean[][] vis=new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1' && !vis[i][j])
                {
                    count++;
                    dfs(grid,vis,i,j);
                }
            }
        }

        return count;
        
    }
    public void dfs(char[][] grid,boolean[][] vis,int i,int j)
    {
        //base
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]!='1'||vis[i][j])
        {
            return;
        }

        // grid[i][j]='2';
        vis[i][j]=true;

        dfs(grid,vis,i+1,j);
        dfs(grid,vis,i-1,j);
        dfs(grid,vis,i,j+1);
        dfs(grid,vis,i,j-1);
    }
}