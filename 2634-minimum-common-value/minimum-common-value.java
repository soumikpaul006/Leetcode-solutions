class Solution {
    public int getCommon(int[] nums1, int[] nums2) 
    {

        int i=0;
        int j=0;
        int ans=-1;

        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j])
            {
                i++;
            }
            else if(nums1[i]>nums2[j])
            {
                j++;
            }
            else
            {
                ans=nums1[i];
                break;
            }
        }

        // return ans!=-1?ans:-1;
        return ans;
        
    }
}