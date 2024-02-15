class Solution {
    public int hIndex(int[] citations) 
    {
        Arrays.sort(citations);
        int len=citations.length;

        for(int i=0;i<citations.length;i++)
        {
            int paper=len-i;

            int citation=citations[i];

            if(citation>=paper)
            {
                return paper;
            }
        }
        
        return 0;
    }
}