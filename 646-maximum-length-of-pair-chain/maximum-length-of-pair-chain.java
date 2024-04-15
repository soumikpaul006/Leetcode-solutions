class Solution 
{

    public int findLongestChain(int[][] pairs) 
    {
        if(pairs.length==1) return 1;
        Arrays.sort(pairs,(a,b)->Integer.compare(a[1],b[1]));

        int count=1;

        List<int[]> list=new ArrayList<>();

        int[] current_interval=pairs[0];

        list.add(current_interval);

        for(int[] pair:pairs)
        {
            int start_of_currentInterval=current_interval[0];
            int end_of_currentInterval=current_interval[1];

            int start_of_newInterval=pair[0];
            int end_of_newInterval=pair[1]; 

            if(start_of_newInterval>end_of_currentInterval)
            {
                count++;
                list.add(pair);
                current_interval=pair;

            }else{
                continue;
            }

        }

        return count;



        
    }
}