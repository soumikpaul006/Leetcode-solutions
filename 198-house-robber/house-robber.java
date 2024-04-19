class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length==1) return nums[0];

        int n=nums.length;

        return helper(nums,n);
    }
    public int helper(int[] nums,int n)
    {
        int prev1=0;
        int prev2=nums[0];

        for(int i=1;i<n;i++)
        {
            int curr=Math.max(nums[i]+prev1,prev2);
            prev1=prev2;
            prev2=curr;

        }

        return prev2;
    }
}