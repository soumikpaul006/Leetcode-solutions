class Solution {
    public int lastStoneWeight(int[] stones) 
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<stones.length;i++)
        {
            pq.add(stones[i]);
        }

        int i=0;

        while(i<pq.size()-1)
        {   
            int x=pq.remove();
            int y=pq.remove();

            if(x!=y){
                pq.add(Math.abs(y-x));
            }
        }

        if(pq.size()==0) return 0;

        return pq.peek();
 
    }
}