class Solution {
    public int[] searchRange(int[] nums, int target) 
    {  
        int fo=firstOcc(nums,target);

        if(fo==-1)
        {
            return new int[]{-1,-1};
        }

        int lo=lastOcc(nums,target);

        return new int[]{fo,lo};
    }
    public int firstOcc(int[] arr,int target)
    {
        int start=0;
        int end=arr.length-1;
        int ans=-1;

        while(start<=end)
        {
            int mid=(start+end)/2;

            if(arr[mid]==target)
            {
                ans=mid;
                end=mid-1;
            }
            else if(arr[mid]<target)
            {
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
    public int lastOcc(int[] arr,int target)
    {
        int start=0;
        int end=arr.length-1;
        int ans=-1;

        while(start<=end)
        {
            int mid=(start+end)/2;
            
            if(arr[mid]==target)
            {
                ans=mid;
                start=mid+1;
            }
            else if(arr[mid]<target)
            {
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
}