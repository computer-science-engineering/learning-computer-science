package EducativeIo.GrokkingTheCodingInterview.Ch05_MergeIntervals.P4_ConflictingAppointments._Variants.P1_FindAllConflictingAppointments.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6),
                new Interval(5, 7), new Interval(7, 8)};
        List<List<Interval>> result = conflictingAppointments(intervals);
        for (List<Interval> item : result) {
            System.out.print("Conflicts: ");
            for (Interval interval : item) {
                System.out.print("[" + interval.start + "," + interval.end + "] ");
            }
        }

    }

    public static List<List<Interval>> conflictingAppointments(Interval[] intervals) {
        // sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<List<Interval>> result = new ArrayList<>();

        // find any overlapping appointment
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                // please note the comparison above, it is "<" and not "<="
                // while merging we needed "<=" comparison, as we will be merging the two
                // intervals having condition "intervals[i].start == intervals[i - 1].end" but
                // such intervals don't represent conflicting appointments as one starts right
                // after the other
                List<Interval> conflicts = new ArrayList<>();
                conflicts.add(intervals[i - 1]);
                conflicts.add(intervals[i]);
                result.add(conflicts);
            }
        }
        return result;
    }
}
