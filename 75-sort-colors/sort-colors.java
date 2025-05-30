class Solution 
{
    public void sortColors(int[] nums) 
    {
        //Dutch National flag algo
        int start=0;
        int end=nums.length-1;
        int mid=0;

        while(mid<=end)
        {
            if(nums[mid]==2){
                swap(nums,mid,end);
                end--;
            }
            else if(nums[mid]==0){
                swap(nums,mid,start);
                start++;
                mid++;
            }
            else{
                mid++;
            }
        }
    }
    public void swap(int[] nums,int start,int end)
    {
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }
}