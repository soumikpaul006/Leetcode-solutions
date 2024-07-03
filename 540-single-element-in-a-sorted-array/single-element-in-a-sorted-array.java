class Solution {
    public int singleNonDuplicate(int[] nums) 
    {
        int start=0;
        int end=nums.length-1;


        while(start<end)
        {
            int mid=(start+end)/2;

            if(mid%2!=0)//odd
            {
                if(nums[mid]==nums[mid-1])
                {
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            else{
                if(nums[mid]==nums[mid+1])
                {
                    start=mid+1;
                }
                else{
                    end=mid;
                }   
            }
        }

        return nums[start];
        
    }
}