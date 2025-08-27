# Problem Definition

## Description

Given an array of intervals representing ‘N’ appointments, find out if a person can **attend all the appointments**.

Example 1:

```plaintext
Appointments: [[1,4], [2,5], [7,9]]
Output: false
Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
```

Example 2:

```plaintext
Appointments: [[6,7], [2,4], [8,12]]
Output: true
Explanation: None of the appointments overlap, therefore a person can attend all of them.
```

Example 3:

```plaintext
Appointments: [[4,5], [2,3], [3,6]]
Output: false
Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
```

## Notes

The problem follows the **Merge Intervals** pattern. We can sort all the intervals by start time and then check if any two intervals overlap. A person will not be able to attend all appointments if any two appointments overlap.

### Time complexity

The time complexity of the above algorithm is O(N \* logN), where ‘N’ is the total number of appointments. Though we are iterating the intervals only once, our algorithm will take O(N \* logN) since we need to sort them in the beginning.

### Space complexity

The space complexity of the above algorithm will be O(N), which we need for sorting. For Java, `Arrays.sort()` uses [Timsort](https://en.wikipedia.org/wiki/Timsort), which needs O(N) space.

## References
