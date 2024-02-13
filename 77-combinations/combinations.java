class Solution 
{
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> final_list=new ArrayList<>();
        backtrack(final_list,new ArrayList<>(),n,k,1);
        return final_list;
    }
    public void backtrack(List<List<Integer>> final_list,List<Integer> new_list, int n, int k, int idx)
    {
        if(new_list.size()==k)
        {
            final_list.add(new ArrayList<>(new_list));
            return;
        }

        for(int i=idx;i<=n;i++)
        {
            new_list.add(i);
            backtrack(final_list,new_list,n,k,i+1);
            new_list.remove(new_list.size()-1);
        }
    }

}