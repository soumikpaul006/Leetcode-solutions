class Solution 
{
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) 
    {
        List<List<Integer>> adj_list=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj_list.add(new ArrayList<>(0));
        }

        //martix
        for(int[] ed:edges)
        {
            adj_list.get(ed[0]).add(ed[1]);
            adj_list.get(ed[1]).add(ed[0]);
        }


        boolean[] visited=new boolean[n];

        int result=dfs(adj_list,hasApple,visited,0);

        return result;
    }
    public int dfs(List<List<Integer>> adj_list,List<Boolean> hasApple,boolean[] visited,int idx)
    {   

        int appleCollectedTime=0;

        //mark edj visited
        visited[idx]=true;

        for(int e:adj_list.get(idx))
        {
            if(!visited[e])
            {
                appleCollectedTime+=dfs(adj_list,hasApple,visited,e);
            }
        }

        if(idx==0)
        {
            return appleCollectedTime;
        }

        if(hasApple.get(idx)||appleCollectedTime>0)
        {
            appleCollectedTime=appleCollectedTime+2;
        }
        
        return appleCollectedTime;

    }
}