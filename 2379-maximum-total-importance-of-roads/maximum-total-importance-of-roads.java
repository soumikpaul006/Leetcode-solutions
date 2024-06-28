class Solution 
{
    class Pair
    {
        int val;
        int freq;

        Pair(int val,int freq)
        {
            this.val=val;
            this.freq=freq;
        }
    }
    public long maximumImportance(int n, int[][] roads) 
    {   

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int[] road:roads)
        {
            int u=road[0];
            int v=road[1];

            map.put(u,map.getOrDefault(u,0)+1);
            map.put(v,map.getOrDefault(v,0)+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.freq-a.freq);

        HashMap<Integer,Integer> map2=new HashMap<>();

        for(int key:map.keySet())
        {
            pq.add(new Pair(key,map.get(key)));
        }

        int num=n;

        while(pq.size()>0)
        {
            Pair pair=pq.remove();
            map2.put(pair.val,num--);
        }

        long total=0;

        for(int[] road:roads)
        {
            total+=(map2.get(road[0])+map2.get(road[1]));
        }

        return total;
    }
}