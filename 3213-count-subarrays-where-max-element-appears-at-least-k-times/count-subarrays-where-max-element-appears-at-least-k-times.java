class Solution 
{
    public long countSubarrays(int[] nums, int k) 
    {
        int max= Arrays.stream(nums).max().getAsInt();

        //finding max elemnet
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(max,nums[i]);
        }

        List<Integer> list=new ArrayList<>();

        long ans=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==max)
            {
                list.add(i);
            }

            int freq=list.size();

            if(freq>=k)
            {
                ans+=list.get(freq-k)+1;
            }
        }
        return ans;
    }

}
