package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.RangeModule.Java;

import java.util.TreeMap;

public class RangeModule {

    TreeMap<Integer, Integer> intervals = new TreeMap<>();
    
    public void addRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        if(start != null && intervals.get(start) >= left) {
            left = start;
        }
        if(end != null && intervals.get(end) > right) {
            right = intervals.get(end);
        }
        intervals.put(left, right);
       
        // clean up intermediate intervals
        intervals.subMap(left, false, right, true).clear();

        // another more easily understood way of removing intermediate intervals
        /*Map<Integer, Integer> subMap = intervals.subMap(left, false, right, true);
        Set<Integer> set = new HashSet(subMap.keySet());
        intervals.keySet().removeAll(set);*/
    }
    
    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        if(start == null) return false;
        return intervals.get(start) >= right;
    }
    
    public void removeRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);

        if(end != null && intervals.get(end) > right) {
            intervals.put(right, intervals.get(end));
        }
        if(start != null && intervals.get(start) > left) {
            intervals.put(start, left);
        }

        // clean up intermediate intervals
        intervals.subMap(left, true, right, false).clear();
    }
}