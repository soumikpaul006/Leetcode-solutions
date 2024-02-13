class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> final_list=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        backtrack(final_list,new ArrayList<>(),nums,used);
        return final_list;
        
    }
    public void backtrack(List<List<Integer>> final_list, List<Integer> new_list, int[] nums,boolean[] used)
    {
        if(new_list.size()==nums.length)
        {
            final_list.add(new ArrayList<>(new_list));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1])   
            {
                continue;
            }   
                   
            used[i]=true;
            new_list.add(nums[i]);
            backtrack(final_list,new_list,nums,used);
            used[i]=false;
            new_list.remove(new_list.size()-1);
        }
    }
}