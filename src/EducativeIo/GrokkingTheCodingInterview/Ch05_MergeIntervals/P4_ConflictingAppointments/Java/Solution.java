package EducativeIo.GrokkingTheCodingInterview.Ch05_MergeIntervals.P4_ConflictingAppointments.Java;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        boolean result = canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
        result = canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
        result = canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        // sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // find any overlapping appointment
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                // please note the comparison above, it is "<" and not "<="
                // while merging we needed "<=" comparison, as we will be merging the two
                // intervals having condition "intervals[i].start == intervals[i - 1].end" but
                // such intervals don't represent conflicting appointments as one starts right
                // after the other
                return false;
            }
        }
        return true;
    }
}
