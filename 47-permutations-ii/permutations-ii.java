class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        Arrays.sort(nums);

        List<List<Integer>> final_list=new ArrayList<>();

        backtrack(final_list,nums,new ArrayList<>(),new boolean[nums.length]);

        return final_list;
    }
    public void backtrack(List<List<Integer>> final_list,int[] nums,List<Integer> temp_list,boolean[] bool)
    {
        if(temp_list.size()==nums.length)
        {
            final_list.add(new ArrayList<>(temp_list));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(bool[i] || (i>0 && nums[i]==nums[i-1] && !bool[i-1] )) continue;

            bool[i]=true;
            temp_list.add(nums[i]);

            backtrack(final_list,nums,temp_list,bool);

            bool[i]=false;
            temp_list.remove(temp_list.size()-1);


        }
    }
      
}