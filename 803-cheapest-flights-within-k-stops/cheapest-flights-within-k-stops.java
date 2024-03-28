class Solution 
{
    class Pair{

        int first;
        int second;

        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    
    class Tuple
    {
        int stop;
        int node;
        int distance;

        Tuple(int stop,int node,int distance)
        {
            this.stop=stop;
            this.node=node;
            this.distance=distance;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        int m=flights[0].length;

        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] flight:flights)
        {
            adj.get(flight[0]).add(new Pair(flight[1],flight[2]));
        }

        Queue<Tuple> q=new LinkedList<>();
        int[] dist=new int[n];


        for(int i=0;i<dist.length;i++)
        {
            dist[i]=(int)(1e9);
        }

        dist[src]=0;
        q.add(new Tuple(0,src,0));

        int[] delrow={+1,0,-1,0};
        int[] delcol={0,+1,0,-1};

        while(!q.isEmpty())
        {
            Tuple t=q.remove();

            int st=t.stop;
            int edge=t.node;
            int cost=t.distance;

            if(st>k) continue;

            for(Pair pair:adj.get(edge))
            {
                int adjNode=pair.first;
                int adjCost=pair.second;

                if(dist[adjNode]>adjCost+cost && st<=k)
                {
                    dist[adjNode]=adjCost+cost;
                    q.offer(new Tuple(st+1,adjNode,adjCost+cost));
                }

            }

        }

        return dist[dst]==(int)(1e9)?-1:dist[dst];


        
    }
}