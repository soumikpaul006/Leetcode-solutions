class Solution 
{
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> final_list=new ArrayList<>();

        backtrack(final_list,nums,new ArrayList<>());

        return final_list;
    }
    public void backtrack(List<List<Integer>> final_list,int[] nums,List<Integer> temp_list)
    {
        if(temp_list.size()==nums.length)
        {
            final_list.add(new ArrayList<>(temp_list));
        }

        for(int i=0;i<nums.length;i++)
        {

            if(temp_list.contains(nums[i]))
            {
                continue;
            }

            temp_list.add(nums[i]);

            backtrack(final_list,nums,temp_list);

            temp_list.remove(temp_list.size()-1);
        }

    }
}