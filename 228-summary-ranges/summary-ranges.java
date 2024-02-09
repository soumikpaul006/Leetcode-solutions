import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        int start = 0;
        int end = 1;

        List<String> list = new ArrayList<>();

        while (end <= nums.length) 
        {
            while (end < nums.length && nums[end] == nums[end - 1] + 1) 
            {
                end++;
            }

            if (start == end - 1) {
                list.add(String.valueOf(nums[start]));
            } else {
                list.add(nums[start] + "->" + nums[end - 1]);
            }

            start = end;
            end = start + 1;
        }

        return list;
    }
}
