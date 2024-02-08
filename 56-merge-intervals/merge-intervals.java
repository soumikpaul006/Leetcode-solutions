class Solution {
    public int[][] merge(int[][] intervals)
    {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list=new ArrayList<>();
        int[] current_interval=intervals[0];

        list.add(current_interval);

        for(int[] interval:intervals)
        {
            int start_of_currentInterval=current_interval[0];
            int end_of_currentInterval=current_interval[1];

            int start_of_newInterval=interval[0];
            int end_of_newInterval=interval[1];

            if(start_of_newInterval<=end_of_currentInterval)
            {
                current_interval[0]=Math.min(start_of_newInterval,start_of_currentInterval);
                current_interval[1]=Math.max(end_of_newInterval,end_of_currentInterval);

            }else{
                list.add(interval);
                current_interval=interval;
            }
        }

        return list.toArray(new int[list.size()][2]);
    }
}