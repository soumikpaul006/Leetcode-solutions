class Solution {
    public int findCircleNum(int[][] isConnected) 
    {
        //create a adjacency list
        List<List<Integer>> adj_list=new ArrayList<>();
        int V=isConnected.length;

        for(int i=0;i<V;i++)
        {
            adj_list.add(new ArrayList<>()); // creatre new nodes
        }

        //create adjacency matrix
        for(int i=0;i<isConnected.length;i++)
        {   
            for(int j=0;j<isConnected[i].length;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    adj_list.get(i).add(j);
                    adj_list.get(j).add(i);
                }
            }
        }


        boolean[] vis=new boolean[adj_list.size()];
        int result=0;
        //applyint dfs on each node
        for(int i=0;i<adj_list.size();i++)
        {
            if(!vis[i])
            {
                result++;
                dfs(adj_list,vis,i);
            }  
        }

        return result;
        
    }
    public void dfs(List<List<Integer>> adj_list,boolean[] vis,int idx)
    {   
        vis[idx]=true;


        for (int neighbor : adj_list.get(idx))// Iterate over neighbors of the current node
        { 
            if (!vis[neighbor])// Check if the neighbor is not visited
            { 
                dfs(adj_list, vis, neighbor); // Recursively visit the neighbor
            }
        }
    }
}