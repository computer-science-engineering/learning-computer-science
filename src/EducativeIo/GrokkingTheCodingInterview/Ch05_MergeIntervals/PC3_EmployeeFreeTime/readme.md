# Problem Definition

## Description

For ‘K’ employees, we are given a list of intervals representing the working hours of each employee. Our goal is to find out if there is a **free interval that is common to all employees**. You can assume that each list of employee working hours is sorted on the start time.

Example 1:

```plaintext
Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
Output: [3,5]
Explanation: Both the employees are free between [3,5].
```

Example 2:

```plaintext
Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
Output: [4,6], [8,9]
Explanation: All employees are free between [4,6] and [8,9].
```

Example 3:

```plaintext
Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
Output: [5,7]
Explanation: All employees are free between [5,7].
```

## Notes

This problem follows the **Merge Intervals** pattern. Let’s take the above-mentioned example (2) and visually draw it:

```plaintext
Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
Output: [4,6], [8,9]
```

One simple solution can be to put the working hours of all employees in a list and sort them on the start time. Then we can iterate through the list to find the gaps. Let’s dig deeper. Sorting the intervals of the above example will give us:

```plaintext
[1,3], [2,4], [6,8], [9,12]
```

We can now iterate through these intervals, and whenever we find non-overlapping intervals (e.g., [2,4] and [6,8]), we can calculate a free interval (e.g., [4,6]). This algorithm will take O(N * logN) time, where ‘N’ is the total number of intervals. This time is needed because we need to sort all the intervals. The space complexity will be O(N), which is needed for sorting. Can we find a better solution?

**Using a Heap to Sort the Intervals**: One fact that we are not utilizing is that each employee list is individually sorted!

How about we take the first interval of each employee and insert it in a **Min Heap**. This **Min Heap** can always give us the interval with the smallest start time. Once we have the smallest start-time interval, we can then compare it with the next smallest start-time interval (again from the **Heap**) to find the gap. This interval comparison is similar to what we suggested in the previous approach.

Whenever we take an interval out of the **Min Heap**, we can insert the next interval of the same employee. This also means that we need to know which interval belongs to which employee.

### Time complexity

The time complexity of the above algorithm is O(N*logK), where ‘N’ is the total number of intervals and ‘K’ is the total number of employees. This is due to the fact that we are iterating through the intervals only once (which will take O(N)), and every time we process an interval, we remove (and can insert) one interval in the Min Heap, (which will take O(logK)). At any time the heap will not have more than ‘K’ elements.

### Space complexity

The space complexity of the above algorithm will be O(K) as at any time the heap will not have more than ‘K’ elements.

## References
