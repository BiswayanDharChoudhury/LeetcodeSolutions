import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sorting intervals based on end times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int nonOverlappingCount = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // Non-overlapping interval found
                nonOverlappingCount++;
                end = intervals[i][1];
            }
        }

        // Calculate the minimum number of intervals to remove
        int toRemove = intervals.length - nonOverlappingCount;
        return toRemove;
    }
}

