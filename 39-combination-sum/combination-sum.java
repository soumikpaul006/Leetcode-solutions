class Solution 
{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> final_list=new ArrayList<>();
        backtrack(final_list,new ArrayList<>(),candidates,0,target,0);
        return final_list;
    }
    public void backtrack(List<List<Integer>> final_list, List<Integer> new_list,int[] arr,int sum,int target, int idx)
    {
        //base
        if(sum==target)
        {
            final_list.add(new ArrayList<>(new_list));
            return;
        }

        for(int i=idx;i<arr.length;i++)
        {
            if(sum + arr[i] <= target) 
            {
                new_list.add(arr[i]);
                backtrack(final_list,new_list,arr,sum+arr[i],target,i);
                new_list.remove(new_list.size()-1);
            }
        }
    }
}