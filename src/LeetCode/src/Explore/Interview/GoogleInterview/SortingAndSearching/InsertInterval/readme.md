# Problem Definition

## Description

Given a set of *non-overlapping* intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

**Example 1:**

```plaintext
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
```

**Example 2:**

```plaintext
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
```

## Notes

1. [Geeks for Geeks - Merge Overlapping Intervals](https://www.geeksforgeeks.org/merging-intervals/)
1. [ProgramCreek - LeetCode – Merge Intervals](https://www.programcreek.com/2012/12/leetcode-merge-intervals/)

    ```java
    public List<Interval> merge(List<Interval> intervals) {
    List<Interval> result = new ArrayList<Interval>();

    if(intervals==null||intervals.size()==0)
        return result;

    Collections.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
            if(i1.start!=i2.start)
                return i1.start-i2.start;
            else
                return i1.end-i2.end;
        }
    });

    Interval pre = intervals.get(0);
    for(int i=0; i<intervals.size(); i++){
        Interval current = intervals.get(i);
        if(current.start>pre.end){
            result.add(pre);
            pre = current;
        }else{
            Interval merged = new Interval(pre.start, Math.max(pre.end, current.end));
            pre = merged;
        }
    }
    result.add(pre);

    return result;
    }
    ```

1. [LeetCode discussion - Short and straight-forward Java solution](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/445/discuss/21602/Short-and-straight-forward-Java-solution)

    ```java
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList();
        if( newInterval == null) {
            return intervals;
        }
        for(int i=0; i< intervals.size();i++) {
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
    ```

1. LeetCode sample submission - 6 ms

    ```java
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }
        return res;
    }
    ```