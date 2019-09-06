# Problem Definition

## Description

You want to build a house on an *empty* land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values **0**, **1** or **2**, where:

* Each **0** marks an empty land which you can pass by freely.
* Each **1** marks a building which you cannot pass through.
* Each **2** marks an obstacle which you cannot pass through.

**Example:**

```plaintext
Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total 
             travel distance of 3+3+1=7 is minimal. So return 7.
```

**Note:** There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

## Notes

1. [LeetCode discussion - Java solution with explanation and time complexity analysis](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/364/discuss/76891/Java-solution-with-explanation-and-time-complexity-analysis/184960)
1. [LeetCode discussion - My BFS Java Solution](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/364/discuss/76942/My-BFS-Java-Solution)
1. [9~10ms JAVA solution beats 98%](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/364/discuss/76930/9~10ms-JAVA-solution-beats-98)
1. [LeetCode discussion - Share a Java implement](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/364/discuss/76886/Share-a-Java-implement)
1. LeetCode sample submission - 2 ms

    ```java
    private int m, n;
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;
        m = grid.length;
        n = grid[0].length;
            int[][] dist = new int[m][n];

            // run BFS from each building
            for (int i = 0; i < m; ++i) 
                    for (int j = 0; j < n; ++j)
                        if (grid[i][j] == 1 && !BFS(grid, dist, i, j))
                            return -1;

            int shortestDistance = Integer.MAX_VALUE;
            for (int i = 0; i < m; ++i)
                    for (int j = 0; j < n; ++j) {
                        if (grid[i][j] == 0 && dist[i][j] < shortestDistance) {
                            shortestDistance = dist[i][j];
                        }
                    }
        if (shortestDistance == Integer.MAX_VALUE)
            return -1;
        return shortestDistance;
    }

    private boolean BFS(int[][] grid, int[][] dist, int row, int col) {
        // visited - an array which records if a node has been visited or not
        boolean visited[][] = new boolean[m][n];
        int dirs[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Deque<int[]> queue = new ArrayDeque<>();
        int level = 0;
        queue.offer(new int[] {row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll(); 
                dist[cur[0]][cur[1]] += level;
                for (int[] dir : dirs) { // visit all neighbors
                    int r1 = cur[0] + dir[0], c1 = cur[1] + dir[1];
                    if (r1 >= 0 && r1 < m && c1 >= 0 && c1 < n) {
                        if (!visited[r1][c1] && grid[r1][c1] == 0)
                            queue.offer(new int[] {r1, c1});
                        visited[r1][c1] = true;
                    }
                }
            }
            level++;
        }

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j]) {
                    if (grid[i][j] == 1)
                        return false;
                    else 
                        grid[i][j] = -1;
                }
            }
        return true;
    }
    ```