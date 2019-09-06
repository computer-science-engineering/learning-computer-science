# Problem Definition

## Description

Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.

Example 1:

```plaintext
Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
Output: 4
Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
```

Example 2

```plaintext
Input: [2, 11, 2, 2, 1], Key=2
Output: 2
Explanation: The first two elements after removing every 'Key' will be [11, 1].
```

## Notes

We can follow a two-pointer approach and shift numbers left upon encountering the ‘key’.

### Time Complexity

The time complexity of the Two Pointers algorithm will be O(N), where ‘N’ is the total number of elements in the given array.

### Space Complexity

The Two Pointers algorithm runs in constant space O(1)O(1).
