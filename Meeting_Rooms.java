/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals)
    {

        if(intervals.size()<=1)return true;
        
        PriorityQueue<Interval> pq=new PriorityQueue<>((a,b)->Integer.compare(a.start,b.start));

        //adding the intevals in the pq based on the first element of the intervals
        for(int i=0;i<intervals.size();i++)
        {
            pq.offer(intervals.get(i));
        }

        List<Interval> list=new ArrayList<>();
        list.add(pq.peek());
        pq.remove();
        int i=0;

        while(!pq.isEmpty())   
        {
            Interval current_interval=list.get(i);
            Interval next_Interval=pq.remove();

            int last_of_current_inteval=current_interval.end;
            int start_of_next_inteval=next_Interval.start;

            if(last_of_current_inteval>start_of_next_inteval)
            {
                return false;
            }else{
                list.add(next_Interval);
                i++;
            }
        }

        return true;
    }
}
