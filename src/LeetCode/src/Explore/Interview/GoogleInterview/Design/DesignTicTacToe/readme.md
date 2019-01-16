# Problem Definition

## Description

Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

1. A move is guaranteed to be valid and is placed on an empty block.
2. Once a winning condition is reached, no more moves is allowed.
3. A player who succeeds in placing _n_ of their marks in a horizontal, vertical, or diagonal row wins the game.

**Example:**

```text
Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
```

**Follow up:** Could you do better than O(_n_<sup>2</sup>) per _move()_ operation?

## Notes

1. [LeetCode discussion - Java O(1) solution, easy to understand](https://leetcode.com/explore/interview/card/google/65/design-4/446/discuss/81898/Java-O(1)-solution-easy-to-understand)
1. [LeetCode discussion - 7/8 lines O(1) Java/Python](https://leetcode.com/explore/interview/card/google/65/design-4/446/discuss/81896/78-lines-O(1)-JavaPython)

    ```java
    public class TicTacToe {
        public TicTacToe(int n) {
            count = new int[6*n][3];
        }

        public int move(int row, int col, int player) {
            int n = count.length / 6;
            for (int x : new int[]{row, n+col, 2*n+row+col, 5*n+row-col})
                if (++count[x][player] == n)
                    return player;
            return 0;
        }

        int[][] count;
    }
    ```

    More [here](leetcode.com/explore/interview/card/google/65/design-4/446/discuss/81898/Java-O(1)-solution-easy-to-understand/86324) and [here](leetcode.com/explore/interview/card/google/65/design-4/446/discuss/81898/Java-O(1)-solution-easy-to-understand/86311)

1. LeetCode sample submission - 61 ms

    ```java
    class TicTacToe {
        int n;
        int[] rows,cols;
        int diag,adiag;

        public TicTacToe(int n) {
            this.n = n;
            rows = new int[n];
            cols = new int[n];
        }

        public int move(int row, int col, int player) {
            int cur = player == 1 ? 1 : -1;
            rows[row] += cur;
            cols[col] += cur;
            if(row == col) diag += cur;
            if(row == n-col-1) adiag += cur;
            if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(adiag) == n) return player;
            return 0;
        }
    }
    ```