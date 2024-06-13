class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> final_list=new ArrayList<>();

        final_list.add(new ArrayList<>());
        final_list.get(0).add(1);  

        for(int i=1;i<numRows;i++)
        {
            List<Integer> temp_list=new ArrayList<>();

            temp_list.add(1);

            List<Integer> prev_list=final_list.get(i-1);

            int size=prev_list.size();

            for(int j=1;j<size;j++)
            {
                temp_list.add(prev_list.get(j-1)+prev_list.get(j));
            }

            temp_list.add(1);
            final_list.add(temp_list);

        } 

        return final_list;
    }
}