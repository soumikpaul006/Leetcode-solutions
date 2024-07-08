class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int[] ans={-1,-1};

        if(nums.length==0) return ans;

        int lb=lowerBound(nums,target);
        int ub=upperBound(nums,target);

        if(lb==nums.length || nums[lb]!=target)
        {
            return new int[]{-1,-1};
        }

        ans[0]=lb;
        ans[1]=ub-1;

        return ans;
    }
    public int lowerBound(int[] arr,int target)
    {
        int start=0;
        int end=arr.length-1;
        int ans=arr.length;

        while(start<=end)
        {
            int mid=(start+end)/2;

            if(arr[mid]>=target)
            {
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    public int upperBound(int[] arr,int target)
    {
        int start=0;
        int end=arr.length-1;
        int ans=arr.length;

        while(start<=end)
        {
            int mid=(start+end)/2;

            if(arr[mid]>target)
            {
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}