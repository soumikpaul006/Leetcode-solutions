class Solution {
    public List<Integer> findDuplicates(int[] nums) 
    {
        if(nums.length==1) return new ArrayList<>();

        List<Integer> list=new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            int idx=Math.abs(nums[i])-1;

            if(nums[idx]>0)
            {
                nums[idx]*=-1;
            }
            else{
                list.add(Math.abs(nums[i]));
            }    
        }

        return list;
    }
}