class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        Set<Integer> set=new HashSet<>();

        int ans=0;

        for(int x:nums)
        {
            set.add(x);
        }

        for(int num:set)
        {
            if(!set.contains(num-1))
            {
                int count=1;
                int n=num;

                while(set.contains(n+1))
                {
                    count++;
                    n++;
                }

                ans=Math.max(ans,count);
            }

        }

        return ans;
    }
}