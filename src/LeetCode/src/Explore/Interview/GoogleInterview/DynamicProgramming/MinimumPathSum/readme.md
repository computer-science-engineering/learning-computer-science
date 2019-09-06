# Problem Definition

## Description

Given a _m_ x _n_ grid filled with non-negative numbers, find a path from top left to bottom right which _minimizes_ the sum of all numbers along its path.

**Note:** You can only move either down or right at any point in time.

**Example:**

```plaintext
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
```

## Notes

1. [LeetCode solution](https://leetcode.com/problems/minimum-path-sum/solution/)
1. [LeetCode discussion - My java solution using DP and no extra space](leetcode.com/explore/interview/card/google/64/dynamic-programming-4/444/discuss/23471/My-java-solution-using-DP-and-no-extra-space/22800)

    ```java
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
            if(i == 0 && j != 0) grid[i][j] += grid[i][j-1];
            if(i != 0 && j == 0) grid[i][j] += grid[i-1][j];
            if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
    ```

1. LeetCode sample submission - 4 ms

    ```java
    public int minPathSum(int[][] grid) {
        Integer[][] memo = new Integer[grid.length][grid[0].length];
        return minPathSum(grid,memo, 0, 0);
    }

    private int minPathSum(int[][] grid, Integer[][] memo, int row, int col) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[grid.length - 1][grid[0].length - 1];
        }
        if (row >= grid.length || col >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (memo[row][col] == null) {
            memo[row][col] = grid[row][col] + Math.min(minPathSum(grid,memo, row + 1, col), minPathSum(grid,memo, row, col + 1));
        }
        return memo[row][col];
    }
    ```