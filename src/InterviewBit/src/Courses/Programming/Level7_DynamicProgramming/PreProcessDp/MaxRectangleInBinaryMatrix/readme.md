# Problem Definition

## Description

Given a 2D binary matrix filled with `0`’s and `1`’s, find the largest rectangle containing **all ones** and return its area.

Bonus if you can solve it in O(n^2) or less.

**Example:**

```plaintext
A : [  1 1 1
       0 1 1
       1 0 0
    ]

Output : 4

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)
```

## Notes

1. [Geeks for Geeks - Maximum size rectangle binary sub-matrix with all 1s](https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/)

    ```plaintext
    Step 1: Find maximum area for row[0]
    Step 2:
        for each row in 1 to N - 1
            for each column in that row
                if A[row][column] == 1
                update A[row][column] with
                    A[row][column] += A[row - 1][column]
        find area for that row
        and update maximum area so far
    ```

1. [ProgramCreek - LeetCode – Maximal Rectangle (Java)](https://www.programcreek.com/2014/05/leetcode-maximal-rectangle-java/)
1. [YT Video - Tushar Roy - Maximum Size Rectangle of All 1's Dynamic Programming](https://www.youtube.com/watch?v=g8bSdXCG-lA)
1. [LeetCode discussion - Share my DP solution](https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution)