import java.util.*;

class Solution 
{
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }   

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        

        int[] result = new int[k];

        for (int i = 0; i < k; i++) 
        {
            result[i] = entries.get(i).getKey();
        }

        return result;
    }
}