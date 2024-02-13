class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> final_list=new ArrayList<>();
        backtrack(final_list,new ArrayList<>(),candidates,0,target,0);
        return final_list;
    }
    public void backtrack(List<List<Integer>> final_list, List<Integer> new_list,int[] arr,int sum,int target, int idx)
    {
        //base

        // if(final_list.contains(new_list)) return;

        if(sum==target)
        {
            final_list.add(new ArrayList<>(new_list));
            return;
        }

        for(int i=idx;i<arr.length;i++)
        {
            if(i>idx && arr[i]==arr[i-1]) continue;

            if(sum + arr[i] <= target) 
            {
                new_list.add(arr[i]);
                backtrack(final_list,new_list,arr,sum+arr[i],target,i+1);
                new_list.remove(new_list.size()-1);
            }
        }
    }
}