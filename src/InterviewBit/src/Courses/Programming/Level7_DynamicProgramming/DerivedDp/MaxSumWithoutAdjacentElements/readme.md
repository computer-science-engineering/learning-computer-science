# Problem Definition

## Description

Given a `2 * N` Grid of numbers, choose numbers such that the sum of the numbers is maximum, and, no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

**Example:**

```text
Grid:
    1 2 3 4
    2 3 4 5
so we will choose
3 and 5 so sum will be 3 + 5 = 8
```

**Note:** You can choose more than 2 numbers

## Notes

1. [Geeks for Geeks - Maximum sum such that no two elements are adjacent](https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/)

    Loop for all elements in arr[] and maintain two sums incl and excl where incl = Max sum including the previous element and excl = Max sum excluding the previous element.

    Max sum excluding the current element will be max(incl, excl) and max sum including the current element will be excl + current element (Note that only excl is considered because elements cannot be adjacent).

    At the end of the loop return max of incl and excl.

1. [YT Video - Tushar Roy - Maximum Sum Subsequence Non-Adjacent](https://www.youtube.com/watch?v=UtGtF6nc35g)
1. [Geeks for Geeks - Maximum sum in a 2 x n grid such that no two elements are adjacent](https://www.geeksforgeeks.org/maximum-sum-2-x-n-grid-no-two-elements-adjacent/)

    This problem is an extension of Maximum sum such that no two elements are adjacent. Only thing to be changed is to take maximum element of both row of a particular column. We traverse column by column and maintain maximum sum considering two cases.
        1. An element of current column is included. In this case we take maximum of two elements in current column.
        1. An element of current column is excluded (or not included).