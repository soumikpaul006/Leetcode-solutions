class Solution 
{
    class Pair
    {
        double first;
        int second;

        Pair(double first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    class Tuple
    {
        double first;
        int second;

        Tuple(double first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) 
    {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new Pair(succProb[i],edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(succProb[i],edges[i][0]));
        }

        double[] cost=new double[n];
        Arrays.fill(cost,-1);
        cost[start_node]=1.0;
        
        //MAX HEAP
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> Double.compare(y.first, x.first));

        pq.add(new Tuple(1.0,start_node));

        while(!pq.isEmpty())
        {
            Tuple t=pq.remove();
            double price=t.first;
            int node=t.second;

            // if()

            for(Pair p:adj.get(node))
            {
                double adjCost=p.first;
                int adjNode=p.second;

                if(cost[adjNode]<price*adjCost)
                {
                    cost[adjNode]=price*adjCost;
                    pq.add(new Tuple(price*adjCost,adjNode));
                }   
            }
        }

        return cost[end_node]==-1?0.0:cost[end_node];

    }
}