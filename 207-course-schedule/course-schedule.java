class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        //Detect a Cycle in a Directed Graph
        //Topological sort BFS


        //form a adj_list

        ArrayList<ArrayList<Integer>> adj_list=new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adj_list.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++)
        {
            adj_list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //in degree
        int[] indegree=new int[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            for(Integer course:adj_list.get(i))
            {
                indegree[course]++;
            }
        }
        

        Queue<Integer> q=new LinkedList<>();

        //add indegree 0 to the q first
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }

        List<Integer> list=new ArrayList<>();

        while(!q.isEmpty())
        {
            int node=q.remove();
            list.add(node);

            for(int neighbors:adj_list.get(node))
            {
                indegree[neighbors]--;

                if(indegree[neighbors]==0)
                {
                    q.offer(neighbors);
                }  

            }
        }

        if(list.size()==numCourses)
        {
            return true;
        }

        return false;
    }
}