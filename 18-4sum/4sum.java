class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        Arrays.sort(nums);

        List<List<Integer>> final_list=new ArrayList<>();

        for(int i=0;i<nums.length-3;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;

            for(int j=i+1;j<nums.length-2;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1]) continue;


                int start=j+1;
                int end=nums.length-1;

                while(start<end)
                {
                    long sum=nums[i];
                    sum+=nums[j];
                    sum+=nums[start];
                    sum+=nums[end];

                    if(sum==target)
                    {
                        List<Integer> list=new ArrayList<>();

                        list.add(nums[i]);
                        list.add(nums[j]);
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

        return final_list;
        
    }
}