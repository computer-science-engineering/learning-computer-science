# Problem Definition

## Description

Given a grid of size `m * n`, lets assume you are starting at `(1,1)` and your goal is to reach `(m,n)`. At any instance, if you are on `(x,y)`, you can either go to `(x, y + 1)` or `(x + 1, y)`.

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

**Example:**

There is one obstacle in the middle of a 3x3 grid as illustrated below.

```text
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
```

The total number of unique paths is `2`.

**Note:** m and n will be at most 100.

## Notes

1. [LeetCode discussion - Clean and simple DP java](https://leetcode.com/problems/unique-paths/discuss/22980/Clean-and-simple-DP-java)
1. [LeetCode discussion - JAVA solution 0ms 4lines](https://leetcode.com/problems/unique-paths/discuss/23090/JAVA-solution-0ms-4lines)
1. [LeetCode article - Unique Paths](https://articles.leetcode.com/unique-paths/)
1. [LeetCode discussion - Short JAVA solution](https://leetcode.com/problems/unique-paths-ii/discuss/23250/Short-JAVA-solution)

    Array dp stores the number of paths which passing this point. The whole algorithm is to sum up the paths from left grid and up grid. 'if (row[j] == 1) dp[j] = 0; means if there is an obstacle at this point. All the paths passing this point will no longer valid. In other words, the grid right of the obstacle can be reached only by the grid which lies up to it.

1. [LeetCode discussion - Easy Java solution, in-place, DP](https://leetcode.com/problems/unique-paths-ii/discuss/23436/Easy-Java-solution-in-place-DP)
1. [ProgramCreek - LeetCode – Unique Paths II (Java)](https://www.programcreek.com/2014/05/leetcode-unique-paths-ii-java/)