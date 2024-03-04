class Solution 
{

    class Pair
    {
        int row;
        int col;
        int dis;
        
        Pair(int row,int col,int dis)
        {
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] grid) 
    {

        int row=grid.length;
        int col=grid[0].length;
        
        Queue<Pair> q=new LinkedList<>();
        
        int[][] visited=new int[row][col];
        int[][] distance=new int[row][col];
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==0)
                {
                    q.offer(new Pair(i,j,0));
                    visited[i][j]=1;
                    distance[i][j]=0;
                }
            }
        }
        
        
        int[] delrow={+1,0,-1,0};
        int[] delcol={0,+1,0,-1};
        
        while(!q.isEmpty())
        {
           int r=q.peek().row;
           int c=q.peek().col;
           int dis=q.peek().dis;
           
           q.remove();
           
           for(int i=0;i<4;i++)
           {
               int nrow=r+delrow[i];
               int ncol=c+delcol[i];
               
               if(nrow>=0 && ncol>=0 && nrow<row && ncol<col && grid[nrow][ncol]==1 && visited[nrow][ncol]==0)
               {
                   q.offer(new Pair(nrow,ncol,dis+1));
                   distance[nrow][ncol]=dis+1;
                   visited[nrow][ncol]=1;
               }
               
           }
        }
        
        return distance;
        
    }
}