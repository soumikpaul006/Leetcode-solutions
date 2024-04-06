class Solution {
    public int maxSubArray(int[] nums) 
    {
        //Brute Force

        // int ans=nums[0];

        // for(int i=0;i<nums.length;i++)
        // {
        //     int max=nums[i];
        //     ans=Math.max(ans,max);

        //     for(int j=i+1;j<nums.length;j++)
        //     {
        //         max=max+nums[j];
        //         ans=Math.max(ans,max);
        //     }
            
        // }

        // return ans;



        //Kadan's Algorithm

        if(nums.length==1) return nums[0];

        int max=nums[0];
        int curr_max=nums[0];

        for(int i=1;i<nums.length;i++)
        {
                // if(nums[i]<nums[i]+curr_max)
                // {
                //     curr_max=curr_max+nums[i];
                // }
                // else{
                //     curr_max=nums[i];
                // }
                
                curr_max=Math.max(nums[i],curr_max+nums[i]);
                max=Math.max(curr_max,max);
        }

        return max;
    }
}