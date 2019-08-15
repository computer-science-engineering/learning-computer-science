package EducativeIo.GrokkingTheCodingInterview.Ch05_MergeIntervals.PC1_MinimumMeetingRooms._Variants.P2_MinimumNumberOfPlatformsForTrainStation.Java;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Interval intervals[] = new Interval[] {new Interval(900, 910), new Interval(940, 1200),
                new Interval(950, 1120), new Interval(1100, 1130), new Interval(1500, 1900),
                new Interval(1800, 2000)};
        System.out.println(
                "Minimum number of platforms needed: " + findMinNumberOfPlatforms(intervals));
    }

    public static int findMinNumberOfPlatforms(Interval intervals[]) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int minPlatforms = 0;
        PriorityQueue<Interval> queue =
                new PriorityQueue<>(intervals.length, (a, b) -> Integer.compare(a.end, b.end));

        for (Interval interval : intervals) {
            while (!queue.isEmpty() && interval.start > queue.peek().end) {
                queue.poll();
            }

            queue.offer(interval);

            minPlatforms = Math.max(minPlatforms, queue.size());
        }
        return minPlatforms;
    }
}
