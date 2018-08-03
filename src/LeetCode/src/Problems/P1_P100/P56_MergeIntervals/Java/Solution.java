package LeetCode.src.Problems.P1_P100.P56_MergeIntervals.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
            new Interval(1,3),
            new Interval(2,6),
            new Interval(8,10),
            new Interval(15,18)
        );
        List<Interval> result = merge(intervals);
        for (Interval interval : result) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
 
        if(intervals==null||intervals.size()==0) {
            return result;
        }
    
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2){
                if(i1.start!=i2.start)
                    return i1.start-i2.start;
                else
                    return i1.end-i2.end;
            }
        });
    
        Interval pre = intervals.get(0);
        for(int i=0; i<intervals.size(); i++) {
            Interval current = intervals.get(i);
            if(current.start>pre.end){
                result.add(pre);
                pre = current;
            } else {
                Interval merged = new Interval(pre.start, Math.max(pre.end, current.end));
                pre = merged;
            }
        }
        result.add(pre);
    
        return result;
    }

    public static List<Interval> merge_opt(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return new ArrayList<Interval>();
        int n = intervals.size();
        int[] start = new int[n], end = new int[n];
        
        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        List<Interval> res = new ArrayList<>();
        int s = start[0], e = end[0];
        for (int i = 1; i < n; i++) {
            if (start[i] <= end[i-1]) {
                e = end[i];
            }
            else {
                res.add(new Interval(s, e));
                s = start[i];
                e = end[i];
            }
        }
        res.add(new Interval(s, e));
        
        return res;
    }
}