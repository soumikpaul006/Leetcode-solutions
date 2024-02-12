class Solution 
{
    public List<List<Integer>> final_list=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        // Arrays.sort(nums);
        // List<List<Integer>> final_list=new ArrayList<>();
        // final_list.add(new ArrayList<>());//add empty list
        // int start=0;
        // int end=0;
        // //iterate over each number
        // for(int i=0;i<nums.length;i++)
        // {
        //     start=0;
        //     if(i>0 && nums[i]==nums[i-1])
        //     {
        //         start=end+1;
        //     }
        //     end=final_list.size()-1;
        //     int size=final_list.size();
        //     for(int j=start;j<size;j++) //interate from start
        //     {
        //         //make a copy the previous list
        //         List<Integer> new_list=new ArrayList<>(final_list.get(j));
        //         //add num to each list
        //         new_list.add(nums[i]);
        //         //add the new_list to the final_list
        //         final_list.add(new_list);
        //     }
        // }
        // return final_list;

        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(),0);
        return final_list;
    }
    public void backtrack(int[] nums,List<Integer> new_list,int idx)
    {
        // if(final_list.contains(new_list)) return;
        final_list.add(new ArrayList<>(new_list));

        for(int i=idx;i<nums.length;i++)
        {
            if(i!=idx && nums[i]==nums[i-1]) continue;

            new_list.add(nums[i]);
            backtrack(nums,new_list,i+1);
            new_list.remove(new_list.size()-1);
        }
    }
}