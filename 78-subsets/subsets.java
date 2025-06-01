class Solution {
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> final_list=new ArrayList<>();

        backtrack(final_list,nums,new ArrayList<>(),0);

        return final_list;
    }
    public void backtrack(List<List<Integer>> final_list,int[] nums,List<Integer> temp_list,int idx)
    {

        for(int i=idx;i<nums.length;i++)
        {
            temp_list.add(nums[i]);

            backtrack(final_list,nums,temp_list,i+1);

            temp_list.remove(temp_list.size()-1);
            
        }

        final_list.add(new ArrayList<>(temp_list));

    }
}