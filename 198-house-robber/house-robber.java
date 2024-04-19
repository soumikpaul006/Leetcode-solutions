class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length==1) return nums[0];

        int n=nums.length;

        return helper(nums,n);
    }
    public int helper(int[] nums,int n)
    {
        int[] dp=new int[n];
        
        dp[0]=nums[0];

        for(int i=1;i<n;i++)
        {
            int if_rob=nums[i];

            if(i>1)
            {
                if_rob+=dp[i-2];
            }
            
            int not_rob=dp[i-1];

            dp[i]=Math.max(if_rob,not_rob);
        }

        return dp[n-1];
    }
}