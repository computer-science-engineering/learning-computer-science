# Problem Definition

## Description

Given two [sparse matrices](https://en.wikipedia.org/wiki/Sparse_matrix) **A** and **B**, return the result of **AB**.

You may assume that **A**'s column number is equal to **B**'s row number.

**Example:**

```text
Input:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

Output:

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
```

## Notes

1. [LeetCode discussion - Easiest JAVA solution](https://leetcode.com/problems/sparse-matrix-multiplication/discuss/76154/Easiest-JAVA-solution)
1. [Sparse Matrix Multiplication](https://www.cs.cmu.edu/~scandal/cacm/node9.html)