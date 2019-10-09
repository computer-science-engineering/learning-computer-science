# Problem Definition

## Description

Given a sorted array of numbers, find if a given number ‘key’ is present in the array. Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order. You should assume that the array can have duplicates.

Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.

Example 1:

```plaintext
Input: [4, 6, 10], key = 10
Output: 2
```

Example 2:

```plaintext
Input: [1, 2, 3, 4, 5, 6, 7], key = 5
Output: 4
```

Example 3:

```plaintext
Input: [10, 6, 4], key = 10
Output: 0
```

Example 4:

```plaintext
Input: [10, 6, 4], key = 4
Output: 2
```

## Discussion

To make things simple, let’s first solve this problem assuming that the input array is sorted in ascending order. Here are the set of steps for **Binary Search**:

Let’s assume `start` is pointing to the first index and `end` is pointing to the last index of the input array (let’s call it `arr`). This means:

```plaintext
    int start = 0;
    int end = arr.length - 1;
```

### Time Complexity

### Space Complexity

## Notes

## References
