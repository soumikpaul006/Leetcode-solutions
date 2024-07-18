class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> final_list=new ArrayList<>();

        final_list.add(new ArrayList<>());
        final_list.get(0).add(1);//adding [1] initailly

        for(int i=1;i<numRows;i++)
        {
            List<Integer> prev_list=final_list.get(i-1);
            int size=prev_list.size();

            List<Integer> inner_list=new ArrayList<>();

            inner_list.add(1);

            for(int j=1;j<size;j++)
            {
                inner_list.add(prev_list.get(j-1)+prev_list.get(j));
            }

            inner_list.add(1);

            final_list.add(inner_list);
        }

        return final_list;
    }
}