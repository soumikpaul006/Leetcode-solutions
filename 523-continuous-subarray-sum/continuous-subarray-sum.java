class Solution {
    public boolean checkSubarraySum(int[] nums, int k) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();

        map.put(0,-1);

        int prefixSum=0;

        for(int i=0;i<nums.length;i++)
        {
            prefixSum+=nums[i];

            if(map.containsKey(prefixSum%k))
            {
                if(i-map.get(prefixSum%k)>1)
                {
                    return true;
                }
            }
            else{
                map.put(prefixSum%k,i);
            }
            
        }

        return false;
        
    }
}