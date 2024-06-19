class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        if(nums.length==0) return 0;
        HashSet<Integer> set=new HashSet<>();

        for(int x:nums)
        {
            set.add(x);
        }

        int max=Integer.MIN_VALUE;

        for(int num:set)
        {
            if(!set.contains(num-1))
            {
                int count=1;
                int currNum=num;

                while(set.contains(currNum+1))
                {
                    count++;
                    currNum++;
                }

                max=Math.max(max,count);
            }
        }

        return max;
    }
}