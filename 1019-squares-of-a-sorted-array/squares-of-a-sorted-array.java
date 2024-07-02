class Solution {
    public int[] sortedSquares(int[] nums) 
    {
        int start=0;
        int end=nums.length-1;
        int[] ans=new int[nums.length];

        List<Integer> list=new ArrayList<>();

        while(start<=end)
        {
            if(Math.abs(nums[start])>Math.abs(nums[end]))
            {
                list.add(0,(nums[start]*nums[start]));
                start++;
            }
            else{
                list.add(0,(nums[end]*nums[end]));
                end--;
            }
        }

        for(int i=0;i<list.size();i++)
        {
            ans[i]=list.get(i);
        }


        
        return ans;
    }
}