// https://www.youtube.com/watch?v=42Z0eaopoZ8
class Solution {

    int count=0;
    public int minReorder(int n, int[][] connections) 
    {
        //adj list

        List<List<Integer>> adj_list=new ArrayList<>();

        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++)
        {
            adj_list.add(new ArrayList<>());
        }

        for(int[] edge:connections)
        {
            adj_list.get(edge[0]).add(edge[1]);
            adj_list.get(edge[1]).add(-edge[0]);// add an opposite edge
        }

        dfs(adj_list,visited,0);

        return count;
    }

    public void dfs(List<List<Integer>> adj_list,boolean[] visited,int root)
    {

        visited[root]=true;

        for(int e:adj_list.get(root))
        {
            if(!visited[Math.abs(e)])
            {
                
                if(e>0)
                {
                    count++;
                }

                dfs(adj_list,visited,Math.abs(e));
            }
        }
    }

}