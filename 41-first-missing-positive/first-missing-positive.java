class Solution {
    public int firstMissingPositive(int[] nums) 
    {   

        int n=nums.length;
       
        for(int i=0;i<n;i++)
        {
            while(nums[i]>0 && nums[i]<=n && nums[i]!=nums[nums[i]-1])
            {
                swap(i,nums[i]-1,nums);
            }
        }

        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]!=j+1)
            {
                return j+1;
            }
        }
        return n+1;
    }
    public void swap(int u,int v,int[] nums)
    {
        int temp=nums[u];
        nums[u]=nums[v];
        nums[v]=temp;
    }
}