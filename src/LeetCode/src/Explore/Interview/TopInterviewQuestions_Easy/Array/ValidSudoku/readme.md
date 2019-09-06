# Problem Definition

## Description

Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

1. Each row must contain the digits `1-9` without repetition.
2. Each column must contain the digits `1-9` without repetition.
3. Each of the 9 `3x3` sub-boxes of the grid must contain the digits `1-9` without repetition.

![A partially filled sudoku which is valid.](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character `'.'`.

**Example 1:**

```plaintext
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
```

**Example 2:**

```plaintext
Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
```

**Note:**

* A Sudoku board (partially filled) could be valid but is not necessarily solvable.
* Only the filled cells need to be validated according to the mentioned rules.
* The given board contain only digits `1-9` and the character `'.'`.
* The given board size is always `9x9`.

## Notes

1. [LeetCode solution](https://leetcode.com/problems/valid-sudoku/solution/)
1. [LeetCode discussion - Shared my concise Java code](https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/discuss/15450/Shared-my-concise-Java-code/146624)

    [ref](https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/discuss/15450/Shared-my-concise-Java-code/115466):

    This solution calculate the traversal of cubes in a not so intuitive way, and that's why it's a little hard to understand at first. For the `rows` and `columns` checking, `(i, j)` stands for the normal coordinate of `board` itself. But for `cube` checking, `i` and `j` actually stands for two different things: `i` is the index of the cube, and `j` is the index of the entry within cube `i`.

    Just see this:

    ```plaintext
    for i in 1..9:
        # traversing cube i
        for j in 1..9:
            # traversing entry j of cube i
            (x, y) = ((i / 3) * 3 + j / 3, (i % 3) * 3 + j % 3), and access board[x, y]
    ```

    To achieve the iteration above, I would instead do traversal like

    ```plaintext
    for i_cube in 0..2: for j_cube in 0..2: for i in 0..2: for j in 0..2:
        (x, y) = (3 * i_cube + i, 3 * j_cube + j) for board[x, y]
    ```

    But this would require more nesting and it would not integrate well with the iterations for rows and columns.

    For `(i, j) = (4, 5)`, consider which block we are looking at? That is cube `i = 4`, but to make calculation of `x, y` easier, we have to change that into 2D coordinate: cube `(4 / 3, 4 % 3) = (1, 1)`. Now, we use `j` to traverse *within* this cube. But how do we do that? Well, we first determine the **base** of this cube, which is its topleft corner. It is easy to calculate as `(1 * 3, 1 * 3) = (3, 3)`. Now we just have to get the bi-directional offsets from `(3,3)` to the position `(4, 5)` within the same cube. That offset is also easy to calculate: `(j / 3, j % 3) = (1, 2)`. Check out the illustration below:

    <img src="http://i63.tinypic.com/21jponl.png" alt="drawing" width="400px" height="400px"/>

    Also, I am sharing how I solved this problem, which I think is easy to understand: just update the counts for the corresponding counts of row/column/cube for each entry traversed:

    ```java
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            if (board.length != 9)
                return false;
            boolean[][] row_seen = new boolean[9][9], col_seen = new boolean[9][9];
            boolean[][][] small_seen = new boolean[3][3][9];
            for (int i = 0; i < 9; i++) {
                if (board[i].length != 9) return false;
                for (int j = 0; j < 9; j++) {
                    char digit = board[i][j];
                    if (digit == '.') continue;
                    if (!Character.isDigit (digit) || digit == '0') return false;
                    int index = digit - '0' - 1;
                    if (row_seen[i][index]) return false;
                    row_seen[i][index] = true;
                    if (col_seen[j][index]) return false;
                    col_seen[j][index] = true;
                    int x = i / 3, y = j / 3;
                    if (small_seen[x][y][index]) return false;
                    small_seen[x][y][index] = true;
                }
            }
            return true;
        }
    }
    ```

1. [YT Video - AceTheCodingInterview - Mock Coding Interview Question: Valid Sudoku [LeetCode]](https://www.youtube.com/watch?v=i2YKwM9oCcY)
1. LeetCode sample submission - 10 ms

    ```java
    public boolean isValidSudoku(char[][] board) {
        int [] vset = new int [9];
        int [] hset = new int [9];
        int [] bckt = new int [9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0') ;
                    if ((hset[i] & idx) > 0 ||
                        (vset[j] & idx) > 0 ||
                        (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }
    ```