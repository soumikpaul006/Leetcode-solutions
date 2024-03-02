// https://www.youtube.com/watch?v=42Z0eaopoZ8
class Solution {
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

        return dfs(adj_list,visited,0);//0 is the root
    }

    public int dfs(List<List<Integer>> adj_list,boolean[] visited,int root)
    {
        int count=0;

        visited[root]=true;

        for(int e:adj_list.get(root))
        {
            if(!visited[Math.abs(e)])
            {
                count+=dfs(adj_list,visited,Math.abs(e))+(e>0?1:0);
            }
        }

        return count;
    }

}