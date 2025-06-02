class Pair{
    int row;
    int col;
    int tmt;

    Pair(int row,int col,int tmt)
    {
        this.row=row;
        this.col=col;
        this.tmt=tmt;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) 
    {
        int row=grid.length;
        int col=grid[0].length;

        int countFresh=0;

        Queue<Pair> q=new LinkedList<>();
        int[][] visited=new int[row][col];


        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==2)//rotten
                {
                    q.offer(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                else{
                    visited[i][j]=0;
                }

                if(grid[i][j]==1)
                {
                    countFresh++;
                }
            }
        }

        int[] delrow={+1,0,-1,0};
        int[] delcol={0,+1,0,-1};

        int count=0;
        int ans=0;

        while(!q.isEmpty())
        {
            int r=q.peek().row;
            int c=q.peek().col;
            int tmt=q.peek().tmt;

            q.remove();

            ans=Math.max(ans,tmt);

            for(int i=0;i<4;i++)
            {
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];

                if(nrow>=0 && ncol>=0 && nrow<row && ncol<col && grid[nrow][ncol]==1 && visited[nrow][ncol]==0)
                {
                    q.offer(new Pair(nrow,ncol,tmt+1));
                    visited[nrow][ncol]=1;

                    count++;
                }
            }
        }

        if(count!=countFresh) return -1;

        return ans;
    }
}