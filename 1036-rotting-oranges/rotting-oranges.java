class Solution 
{
    class Pair
    {
        int row;
        int col;
        int time;

        Pair(int row,int col,int time)
        {
            this.row=row;
            this.col=col;
            this.time=time;
        }

    }
    public int orangesRotting(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;

        int[][] vis=new int[n][m];

        Queue<Pair> q=new LinkedList<>();

        int countFresh=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else
                {
                    vis[i][j]=0;
                }
                
                if(grid[i][j]==1)
                {
                    countFresh++;
                }
            }
        }
        
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,-1,0,+1};

        int count=0;
        int max=0;

        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            int tmt=q.peek().time;

            q.remove();

            max=Math.max(max,tmt);

            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0)
                {
                    q.offer(new Pair(nrow,ncol,tmt+1));
                    vis[nrow][ncol]=2;
                    count++;
                }
            }
        }

        if(count!=countFresh) return -1;

        return max;
    }
}