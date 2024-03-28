class Solution 
{
    class Pair
    {
        int distance;
        int row;
        int col;

        Pair(int distance,int row,int col)
        {
            this.distance=distance;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) 
    {
        //Dijistra Algo
        //TC O(ElogV)

        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);

        int n=heights.length;
        int m=heights[0].length;

        int[][] dist=new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                
                dist[i][j]=(int)(1e9);//infinity
                
            }
        }

        dist[0][0]=0;
        pq.add(new Pair(0,0,0));

        int[] delrow={+1,0,-1,0};
        int[] delcol={0,+1,0,-1};

        while(!pq.isEmpty())
        {
            Pair pair=pq.remove();

            int diff=pair.distance;
            int row=pair.row;
            int col=pair.col;

            if(row==n-1 && col==m-1)
            {
                return diff;
            }

            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];

                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m)
                {
                    int newEffort=Math.max(Math.abs(heights[nrow][ncol]-heights[row][col]),diff);
                    if(dist[nrow][ncol]>newEffort)
                    {
                        dist[nrow][ncol]=newEffort;
                        pq.add(new Pair(newEffort,nrow,ncol));
                    }

                }
            }

        } 

        return 0; 
    }
}