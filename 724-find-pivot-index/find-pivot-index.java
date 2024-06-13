class Solution {
    public int pivotIndex(int[] nums) 
    {
        int sum=0;

        for(int x:nums)
        {
            sum+=x;
        }

        int[] arr1=new int[nums.length];
        int sum1=sum;
        int[] arr2=new int[nums.length];
        int sum2=sum;


        for(int i=nums.length-1;i>=0;i--)
        {
            arr2[i]=sum2-nums[i];
            sum2-=nums[i];
            
        }

        for(int i=0;i<nums.length;i++)
        {
            arr1[i]=sum1-nums[i];
            sum1-=nums[i];
            if(arr1[i]==arr2[i]) return i;
        }  

         

        return -1;
    }
}