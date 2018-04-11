# Problem Definition

## Description

Given a 2D board containing `'X'` and `'O'`, capture all regions surrounded by `'X'`.

A region is captured by flipping all `'O'`s into `'X'`s in that surrounded region.

For example,

```text
X X X X
X O O X
X X O X
X O X X
```

After running your function, the board should be:

```text
X X X X
X X X X
X X X X
X O X X
```

## Notes

1. [ProgramCreek - LeetCode – Surrounded Regions (Java)](https://www.programcreek.com/2014/04/leetcode-surrounded-regions-java/)

    This problem is similar to [Number of Islands](https://www.programcreek.com/2014/04/leetcode-number-of-islands-java/). In this problem, only the cells on the boarders can not be surrounded. So we can first merge those O's on the boarders like in Number of Islands and replace O's with '#', and then scan the board and replace all O's left (if any).

1. [LeetCode discussion - Solve it using Union Find](https://leetcode.com/problems/surrounded-regions/discuss/41617/Solve-it-using-Union-Find)
1. [LeetCode discussion - Simple BFS solution - easy to understand](https://leetcode.com/problems/surrounded-regions/discuss/41825/Simple-BFS-solution-easy-to-understand)
1. [LeetCode discussion - My Very Clean Java Solution](https://leetcode.com/problems/surrounded-regions/discuss/41801/My-Very-Clean-Java-Solution)