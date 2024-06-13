class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
        int[] left=new int[nums.length];
        left[0]=1;

        for(int i=1;i<left.length;i++)
        {
            left[i]=left[i-1]*nums[i-1];
        }

        // for(int i=1;i<left.length;i++)
        // {
        //     System.out.print(left[i]+" ");
        // }

        int[] right=new int[nums.length];
        right[right.length-1]=1;

        for(int i=right.length-2;i>=0;i--)
        {
            right[i]=right[i+1]*nums[i+1];
        }

        // System.out.println();

        // for(int i=1;i<right.length;i++)
        // {
        //     System.out.print(right[i]+" ");
        // }

        int[] ans=new int[left.length];

        for(int i=0;i<left.length;i++)
        {
            ans[i]=left[i]*right[i];
        }

        return ans;

        
    }
}
//1   1    2    6
//24  12   4    1
