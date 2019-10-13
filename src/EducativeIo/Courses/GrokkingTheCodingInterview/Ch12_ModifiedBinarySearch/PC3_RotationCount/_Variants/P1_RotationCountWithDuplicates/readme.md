# Problem Definition

## Description

How do we find the rotation count of a sorted and rotated array that has duplicates too?

Example 1:

```plaintext
Input: [3, 3, 7, 3]
Output: 3
Explanation: The array has been rotated 3 times
```

## Discussion

We can follow the same approach as discussed in **Search in Rotated Array**. The only difference is that before incrementing `start` or decrementing `end`, we will check if either of them is the smallest number.

### Time Complexity

This algorithm will run in O(logN) most of the times, but since we only skip two numbers in case of duplicates instead of the half of the numbers, therefore the worst case time complexity will become O(N).

### Space Complexity

The algorithm runs in constant space O(1).

## Notes

## References
