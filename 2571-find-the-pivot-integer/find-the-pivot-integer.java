class Solution {
    public int pivotInteger(int n) 
    {
        if(n==1) return 1;
        
        int[] arr_1=new int[n+1];
        int[] arr_2=new int[n+1];

        arr_1[0]=0;
        arr_2[arr_2.length-1]=arr_2.length-1;
        for(int i=1;i<arr_1.length;i++)
        {
            arr_1[i]=i+arr_1[i-1];
        }

        for(int i=arr_2.length-2;i>=0;i--)
        {
            arr_2[i]=i+arr_2[i+1];

            if(arr_2[i]==arr_1[i])
            {
                return i;
            }
        }

        return -1;
    }
}