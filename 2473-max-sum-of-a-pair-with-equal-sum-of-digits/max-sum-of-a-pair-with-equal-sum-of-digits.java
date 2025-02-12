class Solution {
    public int maximumSum(int[] nums) 
    {
        int ans=-1;

        HashMap<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            int digit_sum=digitSum(nums[i]);

            if(!map.containsKey(digit_sum))
            {
                List<Integer> newList = new ArrayList<>();
                newList.add(nums[i]);
                map.put(digit_sum, newList);
            }
            else{   

                List<Integer> list=map.get(digit_sum);
                list.add(nums[i]);

                map.put(digit_sum,list);
            }
        }


        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet())
        {
            int size=entry.getValue().size();

            if(size<2) continue;

            else{
                List<Integer> list=entry.getValue();

                Collections.sort(list);

                int sum=list.get(list.size()-1)+list.get(list.size()-2);

                ans=Math.max(ans,sum);
            }
        }

        // if(ans!=-1) return ans;

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