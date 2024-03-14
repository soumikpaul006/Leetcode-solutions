class Solution {
    public boolean isBipartite(int[][] graph) 
    {
        int V=graph.length;
        int[] color=new int[V];

        for(int i=0;i<color.length;i++)
        {
            color[i]=-1;
        }

        //checking for each components
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(!check(i,graph,color))
                {
                    return false;
                }
            }
        }

        return true;
        

    }
    public boolean check(int start,int[][] graph, int[] color)
    {
        
        //BFS

        // Queue<Integer> q=new LinkedList<>();
        // q.offer(start);
        // color[start]=0;


        // while(!q.isEmpty())
        // {
        //     int node=q.remove();
        //     int col=color[node];

        //     for(int neighbors: graph[node])
        //     {
        //         if(color[neighbors]==-1)
        //         {
        //             color[neighbors]=(col==1)?0:1;
        //             q.offer(neighbors);
        //         }
        //         else if(color[neighbors]==col)
        //         {
        //             return false;
        //         }
        //     }
        // }

        // return true;


        //DFS
        int col=color[start];

        for(int neighbors:graph[start])
        {
            if(color[neighbors]==-1) // the neighbors is not color
            {
                color[neighbors]=(col==1)?0:1;

                if(!check(neighbors,graph,color))
                {
                    return false;
                }

            }
            else if(color[neighbors]==col)
            {
                return false;
            }

        }
        return true;

    }
}