class Solution {
    public int timeRequiredToBuy(int[] tickets, int k)
    {

        List<Integer> list=new ArrayList<>();

        int count=0;

        while(tickets[k]>0)
        {
            for(int i=0;i<tickets.length;i++)
            {
                if(tickets[i]>0)
                {
                    tickets[i]--;
                    count++;
                }
                
                if(tickets[k]==0){
                    return count;
                }
            }
            
        }

        for(int i=0;i<tickets.length;i++)
        {
            System.out.print(tickets[i]+" ");
        }

        return count;
        
    }
}