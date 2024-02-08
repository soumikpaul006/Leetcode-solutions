import java.util.*;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length == 1) return 1;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0]; // Sort by start time
            } else {
                return b[1] - a[1]; // If start time is equal, sort by end time in descending order
            }
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastInterval = list.get(list.size() - 1);

            if (currentInterval[1] > lastInterval[1]) {
                list.add(currentInterval);
            }
        }

        return list.size();
    }
}
