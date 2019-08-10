package EducativeIo.GrokkingTheCodingInterview.Ch05_MergeIntervals.P1_MergeIntervals._Variants.FindIfIntervalsOverlap.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(7, 9));
        System.out.println(doesOverlap(intervals));
    }

    public static boolean doesOverlap(List<Interval> intervals) {
        boolean result = false;
        return result;
    }
}
