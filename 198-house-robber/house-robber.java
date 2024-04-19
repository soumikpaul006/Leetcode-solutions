class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length==1) return nums[0];

        int n=nums.length;

        return helper(nums,n);
    }
    public int helper(int[] nums,int n)
    {
        // int[] dp=new int[n];
        
        int prev1=0;
        int prev2=nums[0];

        for(int i=1;i<n;i++)
        {
            int if_rob=nums[i];

            if(i>1)
            {
                if_rob+=prev1;
            }

            int not_rob=prev2;

            int curr=Math.max(if_rob,not_rob);

            prev1=prev2;
            prev2=curr;
        }

        return prev2;
    }
}