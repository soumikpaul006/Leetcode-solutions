class Solution 
{
    List<List<Integer>> final_list=new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);
        int n=nums.length-1;

        for(int i=0;i<nums.length;i++)
        {
            if(i==0||nums[i]!=nums[i-1])
            {
                twoSum(nums,i+1,n,0-nums[i]);
            }
        }

        return final_list;
    }
    public void twoSum(int[] nums,int start,int end,int target)
    {
        int a=nums[start-1];

        while(start<end)
        {
            if(nums[start]+nums[end]==target)
            {
                List<Integer> list=new ArrayList<>();

                list.add(a);
                list.add(nums[start]);
                list.add(nums[end]);

                final_list.add(list);

                while(start<end && nums[start]==nums[start+1])
                {
                    start++;
                }
                while(start<end && nums[end]==nums[end-1])
                {
                    end--;
                }

            }
            if(nums[start]+nums[end]>target)
            {
                end--;
            }
            else{
                start++;
            }
        }

    }

}