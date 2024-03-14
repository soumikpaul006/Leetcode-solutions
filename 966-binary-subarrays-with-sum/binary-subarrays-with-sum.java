class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) 
    {   
        //Brute Force // TC: O(n^2)
        // int count=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     int sum=0;
        //     for(int j=i;j<nums.length;j++)
        //     {
        //         sum+=nums[j];
        //         if(sum==goal)
        //         {
        //             count++;
        //         }
        //     }
        // }

        // return count;

        //HashMap //TC: O(n)

        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int count=0;

        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
           
            if(sum==goal)
            {
                count++;
            }
           
            if(map.containsKey(sum-goal))
            {
                count+=map.get(sum-goal);
            }
            

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}