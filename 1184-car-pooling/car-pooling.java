class Solution {
    public boolean carPooling(int[][] trips, int capacity)
    {
        int[] arr=new int[1001];

        for(int[] trip:trips)
        {
            int passenger=trip[0];
            int initial_loc=trip[1];
            int final_loc=trip[2];

            arr[initial_loc]+=passenger;
            arr[final_loc]+=passenger*(-1);
        }


        int sum=0;

        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum>capacity)
            {
                return false;
            }
        }

        return true;
    }
}