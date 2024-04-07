import java.util.Arrays;

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;

        for (int i = 0; i < nums.length; i++) {
            if (!canReach[i]) continue; // If the current position is not reachable, skip

            int steps = nums[i];
            for (int j = 1; j <= steps; j++) {
                int nextIndex = i + j;
                if (nextIndex >= nums.length) break; // Prevent index out of bounds
                canReach[nextIndex] = true;
                if (nextIndex == nums.length - 1) return true; // Reachable till the end
            }
        }

        return canReach[nums.length - 1];
    }
}
