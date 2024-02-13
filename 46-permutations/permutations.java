class Solution 
{
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> final_list=new ArrayList<>();
        backtrack(final_list,new ArrayList<>(),nums);
        return final_list;     
    }
    public void backtrack(List<List<Integer>> final_list, List<Integer> new_list, int[] nums)
    {
        if(new_list.size()==nums.length)
        {
            final_list.add(new ArrayList<>(new_list));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(new_list.contains(nums[i]))
            {
                continue;
            } 

            new_list.add(nums[i]);
            backtrack(final_list,new_list,nums);
            new_list.remove(new_list.size()-1);
        }
    }
}