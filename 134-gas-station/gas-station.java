class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int totalSurplas=0;
        int remgas=0;
        int start=0;

        for(int i=0;i<gas.length;i++)
        {
            totalSurplas+=gas[i]-cost[i];
            remgas+=gas[i]-cost[i];

            if(remgas<0)
            {
                start=i+1;
                remgas=0;
            }
        }
        return totalSurplas<0?-1:start;
        
    }
}