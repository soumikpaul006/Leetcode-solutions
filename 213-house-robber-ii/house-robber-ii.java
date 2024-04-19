class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length==1) return nums[0];

        int n=nums.length;
        int[] nums1=new int[n-1];
        int[] nums2=new int[n-1];

        //0->n-2
        for(int i=0;i<nums.length-1;i++)
        {
            nums1[i]=nums[i];  
        }

        // 1->n-1
        for(int i = 1; i < nums.length; i++) 
        {
            nums2[i - 1] = nums[i];
        }

        int[] dp1=new int[n-1];
        Arrays.fill(dp1,-1);

        int[] dp2=new int[n-1];
        Arrays.fill(dp2,-1);

        return Math.max(helper(nums1,nums1.length-1,dp1),helper(nums2,nums2.length-1,dp2));
    }
    public int helper(int[] nums,int n,int[] dp)
    {
        if(n<0)
        {
            return 0;
        }

        if(dp[n]!=-1) return dp[n];
        
        int if_rob=nums[n]+helper(nums,n-2,dp);

        int not_rob=helper(nums,n-1,dp);

        return dp[n]=Math.max(if_rob,not_rob);
    
    }
}