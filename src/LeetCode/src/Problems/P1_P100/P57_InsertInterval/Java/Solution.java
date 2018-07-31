package LeetCode.src.Problems.P1_P100.P57_InsertInterval.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));        
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        Interval newInterval = new Interval(4, 8);
        List<Interval> result = insert(intervals, newInterval);
        for (Interval interval : result) {            
            System.out.print("(" + interval.start + " " + interval.end + ") ");
        }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if( newInterval == null) {
            return intervals;
        }
        for(int i=0; i< intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if(newInterval.start < interval.start && newInterval.end < interval.start) { //There is no overlap
                result.add(newInterval);
                result.addAll(intervals.subList(i, intervals.size()));
                return result;
            } else if(newInterval.start > interval.end ) { // new interval does not overlap with interval in the list
                result.add(interval);
            } else { //there is overlap
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        result.add(newInterval);
        return result;
    }
}