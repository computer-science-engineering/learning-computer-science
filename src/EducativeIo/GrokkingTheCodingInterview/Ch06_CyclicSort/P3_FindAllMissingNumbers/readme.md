# Problem Definition

## Description

We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

Example 1:

```text
Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
```

Example 2:

```text
Input: [2, 4, 1, 2]
Output: 3
```

Example 3:

```text
Input: [2, 3, 2, 1]
Output: 4
```

## Notes

This problem follows the **Cyclic Sort** pattern and shares similarities with **Find the Missing Number** with one difference. In this problem, there can be many duplicates whereas in ‘Find the Missing Number’ there were no duplicates and the range was greater than the length of the array.

However, we will follow a similar approach though as discussed in **Find the Missing Number** to place the numbers on their correct indices. Once we are done with the cyclic sort we will iterate the array to find all indices that are missing the correct numbers.

### Time Complexity

### Space Complexity

## References
