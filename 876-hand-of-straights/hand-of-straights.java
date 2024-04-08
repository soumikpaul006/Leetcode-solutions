class Solution 
{
    public boolean isNStraightHand(int[] hand, int groupSize) 
    {

        Arrays.sort(hand);

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<hand.length;i++)
        {
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }

        for(int i=0;i<hand.length;i++)
        {

            int num=hand[i];
            int size=groupSize;

            // Add this check to make sure we're not starting a new group unless the current group is terminated
            //all occurance of num is is already used in making groups; map.get(num)==0;
            if (!map.containsKey(num))
                continue;

            while (size > 0) 
            {
                // If the current group can't be formed, return false
                //if the next value is not present then we still have room to add num then reture false;
                if (!map.containsKey(num))
                    return false; 
                
                // Decrement the count of cards in the group
                map.put(num, map.get(num) - 1);

                if (map.get(num) == 0) {
                    map.remove(num);
                }

                num++;
                size--;
            }

        }


        return map.size()==0?true:false;

    }
}