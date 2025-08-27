# Problem Definition

## Description

How do we search in a sorted and rotated array that also has duplicates?

Example 1:

```plaintext
Input: [3, 3, 7, 3], key = 7
Output: 2
Explanation: '7' is present in the array at index '2'.
```

## Discussion

The only problematic scenario is when the numbers at indices `start`, `middle`, and `end` are the same, as in this case, we can’t decide which part of the array is sorted. In such a case, the best we can do is to skip one number from both ends: `start = start + 1` & `end = end - 1`.

### Time Complexity

This algorithm will run most of the times in O(logN). However, since we only skip two numbers in case of duplicates instead of half of the numbers, the worst case time complexity will become O(N).

### Space Complexity

The algorithm runs in constant space O(1).

## Notes

## References
