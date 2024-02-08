class Solution {
    public int eraseOverlapIntervals(int[][] intervals)
    {

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        //adding intervals by sorting based on last element of the interval;
        for(int[] interval:intervals)
        {
            pq.offer(interval);
        }

        List<int[]> list=new ArrayList<>();

        list.add(pq.peek());
        pq.remove();

        int count=0;
        int i=0;
        
        while(!pq.isEmpty())
        {   
            int[] current_interval=list.get(i);
            int[] new_interval=pq.remove();


            int last_of_current_interval=current_interval[1];
            int start_of_new_interval=new_interval[0];

            if(start_of_new_interval<last_of_current_interval)
            {
                count++;

            }else{
                list.add(new_interval);
                i++;
            }
        }

        return count; 
    }
}