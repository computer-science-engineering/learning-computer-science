# Problem Definition

## Description

Given a list of intervals, **merge all the overlapping intervals** to produce a list that has only mutually exclusive intervals.

Example 1:

```text
Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into one [1,5].
```

Example 2:

```text
Intervals: [[6,7], [2,4], [5,9]]
Output: [[2,4], [5,9]]
Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
```

Example 3:

```text
Intervals: [[1,4], [2,6], [3,5]]
Output: [[1,6]]
Explanation: Since all the given intervals overlap, we merged them into one.
```

## Notes

Let’s take the example of two intervals (‘a’ and ‘b’) such that `a.start <= b.start`. There are three possible scenarios:

1. 'a' and 'b' do not overlap.
2. Some parts of 'b' overlap with 'a'.
3. 'a' fully overlaps 'b'.

Our goal is to merge the intervals whenever they overlap. For the above-mentioned two overlapping scenarios (2 and 3), this is how we will merge them:

1. Sort the intervals on the start time to ensure `a.start <= b.start`.
2. If ‘a’ overlaps ‘b’ (i.e. `b.start <= a.end`), we need to merge them into a new interval ‘c’ such that:

    ```text
    c.start = a.start
    c.end = max(a.end, b.end)
    ```

3. We will keep repeating the above two steps to merge ‘c’ with the next interval if it overlaps with ‘c’.

### Time complexity

The time complexity of the above algorithm is O(N \* logN), where ‘N’ is the total number of intervals. Though we are iterating the intervals only once, our algorithm will take O(N \* logN) since we need to sort them at the beginning.

### Space complexity

The space complexity of the above algorithm will be O(N) as we need to return a list containing all the merged intervals. We will also need O(N) space for sorting. For Java, depending on its version, `Collection.sort()` either uses [Merge sort](https://en.wikipedia.org/wiki/Merge_sort) or [Timsort](https://en.wikipedia.org/wiki/Timsort), and both these algorithms need O(N) space. Overall, our algorithm has a space complexity of O(N).

## References
