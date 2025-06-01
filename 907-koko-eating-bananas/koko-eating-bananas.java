class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        
        int max=Integer.MIN_VALUE;

        for(int i=0;i<piles.length;i++)
        {
            max=Math.max(max,piles[i]);
        }

        int start=1;
        int end=max;

        while(start<=end)
        {
            int k=(start+end)/2;

            int count=0;

            for(int i=0;i<piles.length;i++)
            {
                count+=Math.ceil((double)piles[i]/k);
            }

            if(count>h)//not ok
            {
                start=k+1;

            }else{

                end=k-1;
            }

        }

        return start;
       

    }
}