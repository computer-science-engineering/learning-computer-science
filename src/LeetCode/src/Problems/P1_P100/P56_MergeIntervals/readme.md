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

1. [Geeks for Geeks - Merge Overlapping Intervals](https://www.geeksforgeeks.org/merging-intervals/)
1. [ProgramCreek - LeetCode – Merge Intervals](https://www.programcreek.com/2012/12/leetcode-merge-intervals/)
1. [LeetCode discussion - Beat 98% Java. Sort start & end respectively.](https://leetcode.com/problems/merge-intervals/discuss/21223/Beat-98-Java.-Sort-start-and-end-respectively.)

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

1. [LeetCode discussion - A clean java solution](https://leetcode.com/problems/merge-intervals/discuss/21276/A-clean-java-solution)

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