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

        return Math.max(helper(nums1,nums1.length),helper(nums2,nums2.length));
    }
    public int helper(int[] nums,int n)
    {
        int prev1=0;
        int prev2=nums[0];

        for(int i=1;i<n;i++)
        {
            int if_rob=nums[i];

            if(i>1)
            {
                if_rob+=prev1;
            }

            int no_rob=prev2;

            int curr=Math.max(if_rob,no_rob);
            prev1=prev2;
            prev2=curr;
        }
    
        return prev2;
    
    }
}