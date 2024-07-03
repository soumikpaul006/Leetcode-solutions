class Solution {
    public int mySqrt(int num) 
    {
        if(num==0) return 0;
        if(num==1) return 1;

        int start=1;
        int end=num/2;
        int mid=-1;

        while(start<=end)
        {
            mid=(start+end)/2;

            if(mid*mid==num)
            {
                return mid;
            }
            if((long)mid*mid>(long)num)
            {
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }

        return Math.round(end);
        
    }
}