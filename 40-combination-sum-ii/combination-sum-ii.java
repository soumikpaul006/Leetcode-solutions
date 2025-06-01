class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> final_list=new ArrayList<>();

        backtrack(final_list,new ArrayList<>(),candidates,target,0,0,new boolean[candidates.length]);

        return final_list;
        
    }
    public void backtrack(List<List<Integer>> final_list,List<Integer> temp_list,int[] nums,int target,int sum,int idx,boolean[] bool)
    {
        if(sum==target)
        {
            final_list.add(new ArrayList<>(temp_list));
            return;
        }

        for(int i=idx;i<nums.length;i++)
        {

            if(bool[i] || (i>idx && nums[i]==nums[i-1] && !bool[i-1])) continue;

            if(sum<=target)
            {   

                bool[i]=true;
                temp_list.add(nums[i]);
                backtrack(final_list,temp_list,nums,target,sum+nums[i],i,bool);

                bool[i]=false;
                temp_list.remove(temp_list.size()-1);
            }   
        }

    }
}
