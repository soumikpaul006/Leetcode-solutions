class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {

        if(prerequisites.length==0) return true;

        List<List<Integer>> adj_list=new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adj_list.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++)
        {
            adj_list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree=new int[numCourses];

        for(int i=0;i<adj_list.size();i++)
        {
            List<Integer> list=adj_list.get(i);

            for(int num:list)
            {
                indegree[num]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
                list.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int node=q.remove();

            for(Integer adj_node:adj_list.get(node))
            {
                indegree[adj_node]--;

                if(indegree[adj_node]==0)
                {
                    q.offer(adj_node);
                    list.add(adj_node);
                }
            }
        }

        if(list.size()!=numCourses)
        {
            return false;
        }

        return true;


     
    }
}