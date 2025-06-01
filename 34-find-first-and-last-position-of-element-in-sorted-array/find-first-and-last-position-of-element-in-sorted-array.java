class Solution {
    public int[] searchRange(int[] nums, int target) 
    {  
        int x=firstOcc(nums,target);

        if(x==nums.length || nums[x]!=target)
        {
            return new int[]{-1,-1};
        }

        return new int[]{x,lastOcc(nums,target)};
    }
    public int firstOcc(int[] nums,int target)
    {
        int l=0;
        int r=nums.length-1;

        while(l<=r)
        {
            int mid=(l+r)/2;

            if(nums[mid]>=target)
            {
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return l;
    }
    public int lastOcc(int[] nums,int target)
    {
        int l=0;
        int r=nums.length-1;


        while(l<=r)
        {
            int mid=(l+r)/2;

            if(nums[mid]>target)
            {
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return r;
    }
    
}