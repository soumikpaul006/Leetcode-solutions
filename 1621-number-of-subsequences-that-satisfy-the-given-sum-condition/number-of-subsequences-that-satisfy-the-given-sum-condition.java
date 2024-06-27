class Solution 
{
    public int numSubseq(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int mod = 1_000_000_007;

        int total=0;
        int l=0;
        int r=nums.length-1;

        int[] power=new int[nums.length];
        power[0]=1;

        for(int i=1;i<power.length;i++)
        {
            power[i]=(power[i-1]*2)%mod;
        }

        while(l<=r)
        {
            if(nums[l]+nums[r]<=target)
            {
                total+=power[r-l];
                total%=mod;
                l++;
            }
            else if(nums[l]+nums[r]>target)
            {
                r--;
            }
        }

        return total;
    }
}