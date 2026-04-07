/*Complex (Logic-wise): Merge Intervals

Concept: Sorting + Greedy Overlap
The Challenge: Given a collection of intervals, merge all overlapping intervals.

    Example: [[1,3], [2,6], [8,10]]

    Logic: [1,3] and [2,6] overlap. The new interval is [1,6].

    Result: [[1,6], [8,10]].

The Logic:

    Sort the intervals by their start time.

    Create a "current" interval.

    Compare the end of your current interval with the start of the next one.

    If they overlap, update your current interval's end to the maximum of both. */

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);

        System.out.print("Merged Intervals: ");
        for (int[] i : result) System.out.print(Arrays.toString(i) + " ");
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) { // Overlap found!
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // No overlap, move to next
                currentInterval = interval;
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}