class Pair{
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
class Solution {
    public int orangesRotting(int[][] grid) 
    {
        int row=grid.length;
        int col=grid[0].length;

        int[][] vis=new int[row][col];

        Queue<Pair> q=new LinkedList<>();

        int countFresh=0;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }

                if(grid[i][j]==1)
                {
                    countFresh++;
                }
            }
        }

        int[] delrow={+1,0,-1,0};
        int[] delcol={0,+1,0,-1};

        int ans=0;

        int count=0;

        while(!q.isEmpty())
        {
            int r=q.peek().row;
            int c=q.peek().col;
            int tmt=q.peek().time;

            q.remove();

            ans=Math.max(ans,tmt);

            for(int i=0;i<4;i++)
            {
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];

                if(nrow>=0 && ncol>=0 && nrow<row && ncol<col && grid[nrow][ncol]==1 && vis[nrow][ncol]==0)
                {
                    q.offer(new Pair(nrow,ncol,tmt+1));
                    vis[nrow][ncol]=2;
                    count++;
                }
            }
        }

        if(count!=countFresh) return -1;

        return ans;
   
    }
}