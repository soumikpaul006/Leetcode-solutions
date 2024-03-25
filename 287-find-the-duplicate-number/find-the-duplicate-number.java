class Solution {
    public int findDuplicate(int[] nums)
    {
        int slow=nums[0];
        int fast=nums[0];

        // Step 2: Detect a Cycle
        //In this step, we enter a while loop where the slow pointer moves one step at a time (slow = nums[slow]), 
        //while the fast pointer moves two steps (fast = nums[nums[fast]]). 
        //The loop continues until both pointers meet at some point within the cycle.
        // Note that this meeting point is not necessarily the duplicate number; it's just a point inside the cycle.

        // Why does this happen? Because there is a duplicate number, 
        //there must be a cycle in the 'linked list' created by following nums[i] as next elements. 
        //Once a cycle is detected, the algorithm breaks out of this loop.
        
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        

        //Step 3: Find the Start of the Cycle (Duplicate Number)
        //After identifying a meeting point inside the cycle, we reinitialize the slow pointer back to nums[0]. 
        //The fast pointer stays at the last meeting point. Now, we enter another while loop where both pointers move one step at a time. 
        //The reason behind this is mathematical: according to Floyd's cycle detection algorithm, 
        //when both pointers move at the same speed, they will eventually meet at the starting point of the cycle. 
        //This is the duplicate number we are looking for.

        slow=nums[0];

        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
     
    }
}