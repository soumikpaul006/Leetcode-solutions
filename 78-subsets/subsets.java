class Solution 
{   
    public List<List<Integer>> final_list=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums)
    {
        // List<List<Integer>> final_list=new ArrayList<>();
        // final_list.add(new ArrayList<>());//add empty list

        // //iterate over each number
        // for(int num:nums)
        // {
        //     int size=final_list.size();
        //     for(int i=0;i<size;i++)
        //     {
        //         //make a copy the previous list
        //         List<Integer> new_list=new ArrayList<>(final_list.get(i));
        //         //add num to each list
        //         new_list.add(num);
        //         //add the new_list to the final_list
        //         final_list.add(new_list);
        //     }
        // }
        // return final_list;

        //backtracking approach
        backtrack(nums,new ArrayList<>(),0);
        return final_list;

    }
    public void backtrack(int[] nums,List<Integer> new_list,int idx)
    {
        final_list.add(new ArrayList<>(new_list));

        for(int i=idx;i<nums.length;i++)
        {
            new_list.add(nums[i]);
            backtrack(nums,new_list,i+1);
            new_list.remove(new_list.size()-1);
        }
    }
}
//TC: O(n*2^n)
//TcC: O(n*2^n)
