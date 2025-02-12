class Solution {
    public int maximumSum(int[] nums) 
    {
        int ans=-1;
       
        int[] arr=new int[82];
        Arrays.fill(arr,-1);

        for(int i=0;i<nums.length;i++)
        {
            int digit_sum=digitSum(nums[i]);

            if(arr[digit_sum]!=-1)
            {
                ans=Math.max(ans,nums[i]+arr[digit_sum]);
            }

            arr[digit_sum]=Math.max(arr[digit_sum],nums[i]);

        }

        return ans; 
    }
    public int digitSum(int num)
    {
        int sum=0;

        while(num>0)
        {
            sum+=num%10;
            num=num/10;
        }

        return sum;
    }
}