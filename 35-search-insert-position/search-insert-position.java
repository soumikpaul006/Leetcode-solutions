class Solution {
    public int searchInsert(int[] nums, int target) 
    {
        int l=0;
        int r=nums.length-1;
        int ans=0;

        while(l<=r)
        {
            int mid=(r+l)/2;

            if(nums[mid]>=target) //may be ans answer
            {
                // ans=mid;
                r=mid-1;//look for better options
            }
            else{
                l=mid+1;
            }
        }

        return l;
        
    }
}