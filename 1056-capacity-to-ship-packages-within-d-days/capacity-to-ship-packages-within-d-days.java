class Solution {
    public int shipWithinDays(int[] weights, int days)
    {
        int start = 0; // should be initialized to 0
        int total = 0;

        for (int x : weights) {
            total += x;
            start = Math.max(start, x); // find the max weight
        }

        int end = total;
        
        while(start<=end)
        {
            int cap=(start+end)/2;

            if(helper(weights,cap,days))
            {
                end=cap-1;
            }
            else{
                start=cap+1;
            }
        }
        return start;
    }
    public boolean helper(int[] arr, int cap, int days) {
        int total = 0;
        int dayCount = 1; // start with one day

        for (int x : arr) {
            total += x;

            if (total > cap) {
                total = x; // start a new day with the current weight
                dayCount++;

                if (dayCount > days) {
                    return false;
                }
            }
        }

        return true;
    }
}