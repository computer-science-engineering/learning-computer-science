# Problem Definition

## Description

Given a 2d grid map of `'1'`s (land) and `'0'`s (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

**Example 1:**

```plaintext
Input:
11110
11010
11000
00000

Output: 1
```

**Example 2:**

```plaintext
Input:
11000
11000
00100
00011

Output: 3
```

## Notes

1. [LeetCode discussion - Simple Java Solution](https://leetcode.com/problems/number-of-islands/discuss/56347/Simple-Java-Solution)

    Scan each cell in the grid.
    If the cell value is '1' explore that island.
    Mark the explored island cells with 'x'.
    Once finished exploring that island, increment islands counter.

1. [LeetCode discussion - Very concise Java AC solution](https://leetcode.com/problems/number-of-islands/discuss/56359/Very-concise-Java-AC-solution)
1. [LeetCode discussion - 1D Union Find Java solution, easily generalized to other problems](https://leetcode.com/problems/number-of-islands/discuss/56354/1D-Union-Find-Java-solution-easily-generalized-to-other-problems)
1. [LeetCode discussion - Java Union Find Solution](https://leetcode.com/problems/number-of-islands/discuss/56364/Java-Union-Find-Solution)
1. [LeetCode discussion - Java DFS and BFS solution](https://leetcode.com/problems/number-of-islands/discuss/56338/Java-DFS-and-BFS-solution)
1. [LeetCode article](https://leetcode.com/articles/number-of-islands/)