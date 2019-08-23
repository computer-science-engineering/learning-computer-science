# Problem Definition

## Description

We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array has some duplicates, find all the duplicate numbers without using any extra space.

Example 1:

```text
Input: [3, 4, 4, 5, 5]
Output: [4, 5]
```

Example 2:

```text
Input: [5, 4, 7, 2, 3, 5, 3]
Output: [3, 5]
```

## Notes

This problem follows the **Cyclic Sort** pattern and shares similarities with **Find the Duplicate Number**. Following a similar approach, we will place each number at its correct index. After that, we will iterate through the array to find all numbers that are not at the correct indices. All these numbers are duplicates.

### Time Complexity

### Space Complexity

## References
