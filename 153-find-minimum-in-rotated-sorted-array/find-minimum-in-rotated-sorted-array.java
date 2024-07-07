class Solution 
{
    public int findMin(int[] nums) 
    {
        if(nums.length==1)
        {
            return nums[0];
        } 

        int start=0;
        int end=nums.length-1;

        while(start<=end)
        {
            int mid=(start+end)/2;

            if(nums[start]>nums[end])
            {
                start++;
            }
            else{
                return nums[start];
            }
        }
        return nums[start];

        
    }
}