class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> final_list=new ArrayList<>();

        backtrack(final_list,new ArrayList<>(),candidates,target,0,0);

        return final_list;
    }
    public void backtrack(List<List<Integer>> final_list,List<Integer> temp_list,int[] nums,int target,int sum,int idx)
    {
        if(sum==target)
        {
            final_list.add(new ArrayList<>(temp_list));
            return;
        }

        for(int i=idx;i<nums.length;i++)
        {
            if(sum<=target)
            {   
                temp_list.add(nums[i]);
                backtrack(final_list,temp_list,nums,target,sum+nums[i],i);
                temp_list.remove(temp_list.size()-1);
            }   
        }

    }
}