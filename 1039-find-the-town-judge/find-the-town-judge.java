class Solution {
    public int findJudge(int n, int[][] trust) 
    {
        if(trust.length==0 && n==1) return 1;
        int[] arr=new int[n+1];

        for(int[] person:trust)
        {
            arr[person[0]]--;
            arr[person[1]]++;
        }


        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==n-1) return i;
        }

        return -1;

             
    }
}