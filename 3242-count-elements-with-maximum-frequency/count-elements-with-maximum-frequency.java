class Solution {
    public int maxFrequencyElements(int[] nums) 
    {
        int[] arr=new int[101];
        int max=Integer.MIN_VALUE;

        //calculate frequency of the element
        for(int i=0;i<nums.length;i++)
        {
            arr[nums[i]]++;
            if(max<arr[nums[i]])
            {
                max=arr[nums[i]];
            }
        }

        int count=0;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==max)
            {
                count=count+arr[i];
            }
        }

        return count;



     
    }
}