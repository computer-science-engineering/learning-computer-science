package EducativeIo.GrokkingTheCodingInterview.Ch05_MergeIntervals.PC1_MinimumMeetingRooms._Variants.P1_MaximumNumberOfIntervalsOverlapPoint.Java;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Interval intervals[] = new Interval[] {new Interval(1, 4), new Interval(2, 5),
                new Interval(9, 12), new Interval(5, 9), new Interval(5, 12)};
        System.out.println(findMaxOverlapPoint(intervals));
    }

    public static int findMaxOverlapPoint(Interval intervals[]) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int maxIntervals = 0;
        int result = 0;
        PriorityQueue<Interval> queue =
                new PriorityQueue<>(intervals.length, (a, b) -> Integer.compare(a.end, b.end));

        for (Interval interval : intervals) {
            while (!queue.isEmpty() && interval.start > queue.peek().end) {
                queue.poll();
            }

            queue.offer(interval);

            int maxIntervalsTemp = Math.max(maxIntervals, queue.size());
            if (maxIntervalsTemp > maxIntervals) {
                System.out.println(queue.peek().start + " " + queue.peek().end);
                System.out.println(maxIntervalsTemp);
                maxIntervals = maxIntervalsTemp;
            }
        }

        return result;
    }
}
