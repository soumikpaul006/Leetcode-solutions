class Solution
{
    public int[] productExceptSelf(int[] nums)
    {   
        int len=nums.length;

        int[] left=new int[len];
        int[] right=new int[len];
        int[] output=new int[len];

        left[0]=1;

        for(int i=1;i<left.length;i++)
        {
            left[i]=nums[i-1]*left[i-1];
        }

        right[len-1]=1;

        for(int i=len-2;i>=0;i--)
        {
            right[i]=right[i+1]*nums[i+1];
        }

        for(int i=0;i<output.length;i++)
        {
            output[i]=right[i]*left[i];
        }

        return output; 
    }
}


// 1   1   2  6
// 24  12  4  1 