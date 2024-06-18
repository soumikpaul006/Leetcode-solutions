class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int max=0;
        int start=prices[0];

        for(int i=0;i<prices.length;i++)
        {

                if(prices[i]<=start)
                {
                    start=prices[i];
                }

                if(prices[i]>start)
                {
                    max+=prices[i]-start;
                    start=prices[i];
                }
                
        }

        return max;
    }
}