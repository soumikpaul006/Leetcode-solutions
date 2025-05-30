class Solution 
{
    public int[] topKFrequent(int[] nums, int k) 
    {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++) //frequency counter
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            pq.add(entry.getKey());
        }

        int[] ans=new int[k];
        int i=0;

        while(!pq.isEmpty() && k>0)
        {
            ans[i++]=pq.remove();
            k--;
        }

        return ans;
    }
}