class Solution {
    public int splitArray(int[] nums, int k) 
    {
        int start=0;
        int end=0;

    
        for(int i=0;i<nums.length;i++)
        {
            end+=nums[i];
            start=Math.max(start,nums[i]);
        }


        while(start<=end)
        {
            int mid=start+(end-start)/2;

            int sum=0;
            int subset=1;

            for(int num:nums)
            {
                if(sum+num>mid)
                {
                    subset++;
                    sum=num;
                }else{
                    sum+=num;
                }
            }

            if(subset<=k) //the mid is a possible answer but we need to minimized your search
            {
                end=mid-1;
                
            }else{
                start=mid+1;
            }

        }
        return start;
        
    }
}