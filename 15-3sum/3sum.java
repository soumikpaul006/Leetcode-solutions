class Solution 
{
    List<List<Integer>> final_list=new ArrayList<>();
    
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++)
        {
            if(i==0 || nums[i]!=nums[i-1])
            {
                twoSum(nums,nums[i],i+1,-nums[i],nums.length-1);
            }
        }

        return final_list;
    }
    public void twoSum(int[] nums,int ele,int start,int target,int end)
    {

        while(start<end)
        {
            int sum=nums[start]+nums[end];

            if(sum==target)
            {
                List<Integer> list=new ArrayList<>();
                list.add(ele);
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
                start++;
                end--;
            }
            else if(sum>target)
            {
                end--;
            }
            else{
                start++;
            }
        }
    }
}