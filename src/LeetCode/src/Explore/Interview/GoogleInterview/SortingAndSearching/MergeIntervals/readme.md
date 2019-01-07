# Problem Definition

## Description

Given a collection of intervals, merge all overlapping intervals.

**Example 1:**

```text
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```

**Example 2:**

```text
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

## Notes

1. [LeetCode solution](https://leetcode.com/problems/merge-intervals/solution/)
1. [Geeks for Geeks - Merge Overlapping Intervals](https://www.geeksforgeeks.org/merging-intervals/)
1. [LeetCode discussion - A simple Java solution](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/450/discuss/21222/A-simple-Java-solution)

    ```java
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }
    ```

1. [LeetCode discussion - A-simple-Java-solution/148063](leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/450/discuss/21222/A-simple-Java-solution/148063)

    ```java
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<Interval>();
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.size(), (a, b) -> (a.start - b.start));
        for (int i = 0; i < intervals.size(); i++) {
            pq.offer(intervals.get(i));
        }
        while (pq.size() > 1) {
            Interval i1 = pq.poll();
            Interval i2 = pq.poll();
            if (i1.end >= i2.start) {
                Interval node = new Interval(i1.start, Math.max(i2.end, i1.end));
                pq.offer(node);
            } else {
                result.add(i1);
                pq.offer(i2);
            }
        }
        result.add(pq.poll());
        return result;
    }
    ```

1. [LeetCode discussion - Beat 98% Java. Sort start & end respectively.](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/450/discuss/21223/Beat-98-Java.-Sort-start-and-end-respectively.)

    The idea is that for the result distinct Interval, the latter one's start must > previous one's end.

    ```java
    public List<Interval> merge(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
    ```

1. [LeetCode discussion - A-clean-java-solution/141272](leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/450/discuss/21276/A-clean-java-solution/141272)

    ```java
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals)
            if (merged.isEmpty() || merged.getLast().end < interval.start)
                merged.add(interval);
            else merged.getLast().end = Math.max(merged.getLast().end, interval.end);
        return merged;
    }
    ```

1. LeetCode sample submission - 7 ms

    ```java
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0 || intervals.size() == 1) {
            return intervals;
        }
        List<Interval> result = new ArrayList<>();
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);
            start[i] = temp.start;
            end[i] = temp.end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = start[0];
        int e = end[0];
        int i = 1;
        int j = 0;
        while(i < intervals.size()) {
            if(start[i] > end[j]) {
                Interval temp = new Interval(s, e);
                result.add(temp);
                s = start[i];
            }
            i++;
            j++;
            e = end[j];
        }
        Interval temp = new Interval(s, e);
        result.add(temp);
        return result;
    }
    ```
