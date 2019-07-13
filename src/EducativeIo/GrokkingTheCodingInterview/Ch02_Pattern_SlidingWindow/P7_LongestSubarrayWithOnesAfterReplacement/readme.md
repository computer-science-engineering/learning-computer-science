# Problem Definition

## Description

Given an array containing 0s and 1s, if you are allowed to **replace no more than 'k' 0s with 1s**, find the length of the **longest subarray having all 1s**.

Example 1:

```text
Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest subarray of 1s having length 6.
```

Example 2:

```text
Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest subarray of 1s having length 9.
```

## Notes

### Time Complexity

For the Sliding Window algorithm, the time complexity is O(N) where 'N' is the count of numbers in the input array.

### Space Complexity

For the Sliding Window algorithm, the algorithm runs in constant space O(1).
