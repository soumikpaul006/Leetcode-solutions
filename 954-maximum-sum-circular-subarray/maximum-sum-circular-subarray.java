class Solution {
    public int maxSubarraySumCircular(int[] nums)
    {
        int curr_max=nums[0];
        int max=nums[0];

        int curr_min=nums[0];
        int min=nums[0];

        int total = nums[0];



        for(int i=1;i<nums.length;i++)
        {
            curr_max=Math.max(nums[i],curr_max+nums[i]);
            max=Math.max(max,curr_max);

            curr_min=Math.min(nums[i],curr_min+nums[i]);
            min=Math.min(min,curr_min);

            total+=nums[i];
        }


        if(min==total) //if all the elements are -ve;
        {
            return max;
        }

        return Math.max(max,total-min);
        
    }
}