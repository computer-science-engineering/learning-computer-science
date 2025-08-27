# Problem Definition

## Description

Given two lists of intervals, find the **intersection of these two lists**. Each list consists of **disjoint intervals sorted on their start time**.

Example 1:

```plaintext
Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
Output: [2, 3], [5, 6], [7, 7]
Explanation: The output list contains the common intervals between the two lists.
```

Example 2:

```plaintext
Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
Output: [5, 7], [9, 10]
Explanation: The output list contains the common intervals between the two lists.
```

## Notes

This problem follows the **Merge Intervals** pattern. As we have discussed under **Insert Interval**, there are five overlapping possibilities between two intervals ‘a’ and ‘b’:

1. 'a' and 'b' do not overlap.
2. 'a' and 'b' overlap, 'b' start time lies within 'a' and 'b' ends after 'a'.
3. 'a' and 'b' overlap, 'b' start and end times lies within 'a' i.e., 'a' completely overlaps 'b'.
4. 'a' and 'b' overlap, 'a' start time lies within 'b' and 'a' ends after 'b'.
5. 'a' and 'b' overlap, 'a' start and end times lies within 'b' i.e., 'b' completely overlaps 'a'.

So there are four scenarios when the two intervals overlap (2-5). Close observation will reveal that whenever the two intervals overlap, one of the interval’s start time lies within the other interval. This rule can help us identify if any two intervals overlap or not.

Secondly, if we have found that two intervals overlap, how can we find the overlapped part?

Again from the above diagram, the overlapping interval will be equal to:

```java
start = max(a.start, b.start)
end = min(a.end, b.end)
```

That is, the highest start time and the lowest end time will be the overlapping interval.

So our algorithm will be to iterate through both the lists together to see if any two intervals overlap. If two intervals overlap, we will insert the overlapped part into a result list and move on to the next interval which is finishing early.

### Time complexity

As we are iterating through both the lists once, the time complexity of the above algorithm is O(N + M), where ‘N’ and ‘M’ are the total number of intervals in the input arrays respectively.

### Space complexity

Ignoring the space needed for the result list, the algorithm runs in constant space O(1).

## References
