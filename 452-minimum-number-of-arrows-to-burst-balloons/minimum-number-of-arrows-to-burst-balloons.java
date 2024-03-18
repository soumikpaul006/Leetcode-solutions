class Solution {
    public int findMinArrowShots(int[][] points) 
    {   
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        for(int[] point:points)
        {
            pq.add(point);
        }

        List<int[]> list=new ArrayList<>();
        list.add(pq.remove());

        int count=1;
        int i=0;

        while(!pq.isEmpty())
        {
            int[] current_interval=list.get(i);
            int[] new_interval=pq.remove();

            int start_current_interval=current_interval[0];
            int end_current_interval=current_interval[1];
            int start_new_interval=new_interval[0];
            int end_new_interval=new_interval[1];

            if(start_new_interval>end_current_interval)
            {
                count++;
                list.add(new_interval);
                i++;
            }
        }
        return count;

        
    }
}