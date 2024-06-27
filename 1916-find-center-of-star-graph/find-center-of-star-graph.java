class Solution 
{
    public int findCenter(int[][] edges) 
    {
        int ed=edges.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        

        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];

            map.put(u,map.getOrDefault(u,0)+1);
            map.put(v,map.getOrDefault(v,0)+1);
        }

        // for (Map.Entry<Integer,Integer> mapElement : map.entrySet()) 
        // {
        //     System.out.println(mapElement.getKey()+" "+mapElement.getValue());
        // }

        for (Map.Entry<Integer,Integer> mapElement : map.entrySet()) 
        {
            if(mapElement.getValue()==ed)
            {
                return mapElement.getKey();
            }
        }
        return -1;
        
    }
}