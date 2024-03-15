class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) 
    {
        List<Integer> ans_list=new ArrayList<>();

        int V=graph.length;

        int[] visited=new int[V];
        int[] path_visited=new int[V];
        int[] check=new int[V]; //keep track of safe nodes
    
    
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                dfs(i,graph,visited,path_visited,check);   
            }
        }
        
        for(int i=0;i<V;i++)
        {
            if(check[i]==1)
            {
                ans_list.add(i);
            }
        }
    
        return ans_list;
        
    }
    public boolean dfs(int node,int[][] graph, int[] visited,int[] path_visited,int[] check)
    {
        visited[node]=1;
        path_visited[node]=1;
        check[node]=0; //intitialise it with 0
        
        for(int neighbors:graph[node])
        {
            if(visited[neighbors]==0)
            {
                
                dfs(neighbors,graph,visited,path_visited,check);
            }
            if(visited[neighbors]==1 && path_visited[neighbors]==1)//found cycyle
            {
                return true;
            }
        }
        
        check[node]=1; //if the node is not in the cycle the assign it with 1
        path_visited[node]=0;

        return false;
    }
}