class Solution 
{
    public boolean canJump(int[] nums) 
    {
        if(nums.length==1) return true;
        if(nums[0]==0) return false;
        boolean[] arr=new boolean[nums.length];
        Arrays.fill(arr,false);

        arr[0]=true;

        for(int i=0;i<nums.length;i++)
        {

            if(!arr[i]) continue;

            int num=nums[i];

            int j=i+1;

            while(j<nums.length && num>0)
            {
                arr[j++]=true;

                if(arr[nums.length-1]) return true;

                num--;
            }   
        }

        return false;   
    }
}