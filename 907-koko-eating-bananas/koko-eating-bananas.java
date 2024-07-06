class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        int start=1;
        int end=0;

        for(int x:piles)
        {
            end=Math.max(x,end);
        }


        while(start<end)
        {
            int speed=(start+end)/2;

            int total=0;

            for(int pile:piles)
            {
                total+=Math.ceil((double)pile/speed);
            }

            if(total<=h)
            {
                end=speed;
            }
            else{
                start=speed+1;
            }
        }

        return end;

    }
}