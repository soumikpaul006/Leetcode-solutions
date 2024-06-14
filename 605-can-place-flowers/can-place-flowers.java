class Solution {
    public boolean canPlaceFlowers(int[] num, int n) 
    {
        if(n==0) return true;

        for(int i=0;i<num.length;i++)
        {
            if((i==0||num[i-1]==0) && num[i]==0 &&  (i==num.length-1||num[i+1]==0))
            {
                num[i]=1;
                n--;
            }
            if(n==0)
            {
                return true;
            }
        }

        System.out.print(n);

        return false;
    }
}