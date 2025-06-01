class Solution {
    public int singleNonDuplicate(int[] nums) 
    {
       int l=0;
       int r=nums.length-1;


       while(l<r)
       {
            int mid=(l+r)/2;

            if(mid%2==0)
            {
                if(nums[mid]!=nums[mid+1]) //element lies in left
                {
                    r=mid;
                }
                else{
                    l=mid+1;
                }
            }
            else{

                if(nums[mid]!=nums[mid+1])
                {
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
       }

       return nums[l];
        
    }
}