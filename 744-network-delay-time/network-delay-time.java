class Solution 
{
    class Pair
    {
        int node;
        int distance;

        Pair(int node,int distance)
        {
            this.node=node;
            this.distance=distance;
        }
    }

    class Tuple
    {
        int node;
        int distance;

        Tuple(int node,int distance)
        {
            this.node=node;
            this.distance=distance;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] time:times)
        {
            adj.get(time[0]).add(new Pair(time[1],time[2]));
        } 

        PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);

        int[] dist=new int[n+1];

        for(int i=0;i<dist.length;i++)
        {
            dist[i]=(int)(1e9);
        }

        dist[k]=0;
        pq.add(new Tuple(k,0));

        while(!pq.isEmpty())
        {
            Tuple t=pq.remove();
            int node=t.node;
            int distance=t.distance;

            for(Pair pair:adj.get(node))
            {
                int adjNode=pair.node;
                int adjCost=pair.distance;

                if(dist[adjNode]>distance+adjCost)
                {
                    dist[adjNode]=distance+adjCost;
                    pq.add(new Tuple(adjNode,dist[adjNode]));
                }
            }
        }
        
        int max=Integer.MIN_VALUE;
        for(int i=1;i<dist.length;i++)
        {
            if(dist[i]==(int)(1e9))
            {
                return -1;
            }else{
                max=Math.max(max,dist[i]);
            }
        }

        return max;
    }
}