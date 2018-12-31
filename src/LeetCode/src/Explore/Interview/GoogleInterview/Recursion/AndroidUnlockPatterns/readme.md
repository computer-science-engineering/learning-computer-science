# Problem Definition

## Description

Given an Android **3x3** key lock screen and two integers **m** and **n**, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of **m** keys and maximum **n** keys.

**Rules for a valid pattern:**

1. Each pattern must connect at least **m** keys and at most **n** keys.
2. All the keys must be distinct.
3. If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
4. The order of keys used matters.

![android-unlock.png](https://assets.leetcode.com/uploads/2018/10/12/android-unlock.png)

**Explanation:**

```text
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
```

**Invalid move:** `4 - 1 - 3 - 6`

Line 1 - 3 passes through key 2 which had not been selected in the pattern.

**Invalid move:** `4 - 1 - 9 - 2`

Line 1 - 9 passes through key 5 which had not been selected in the pattern.

**Valid move:** `2 - 4 - 1 - 3 - 6`

Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

**Valid move:** `6 - 5 - 4 - 1 - 9 - 2`

Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

**Example:**

```text
Input: m = 1, n = 1
Output: 9
```

## Notes

1. [LeetCode discussion - Sharing my bitmask dynamic programming solution (4ms)](https://leetcode.com/explore/interview/card/google/62/recursion-4/484/discuss/82483/Sharing-my-bitmask-dynamic-programming-solution-(4ms))
1. [LeetCode discussion - Java DFS solution with clear explanations and optimization, beats 97.61% (12ms)](https://leetcode.com/explore/interview/card/google/62/recursion-4/484/discuss/82463/Java-DFS-solution-with-clear-explanations-and-optimization-beats-97.61-(12ms))
1. [LeetCode discussion - Simple and concise Java solution in 69ms](https://leetcode.com/explore/interview/card/google/62/recursion-4/484/discuss/82464/Simple-and-concise-Java-solution-in-69ms)

    ```java
    private int[][] jumps;
    private boolean[] visited;

    public int numberOfPatterns(int m, int n) {
        jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        visited = new boolean[10];
        int count = 0;
        count += DFS(1, 1, 0, m, n) * 4; // 1, 3, 7, 9 are symmetrical
        count += DFS(2, 1, 0, m, n) * 4; // 2, 4, 6, 8 are symmetrical
        count += DFS(5, 1, 0, m, n);
        return count;
    }

    private int DFS(int num, int len, int count, int m, int n) {
        if (len >= m) count++; // only count if moves are larger than m
        len++;
        if (len > n) return count;
        visited[num] = true;
        for (int next = 1; next <= 9; next++) {
            int jump = jumps[num][next];
            if (!visited[next] && (jump == 0 || visited[jump])) {
                count = DFS(next, len, count, m, n);
            }
        }
        visited[num] = false; // backtracking
        return count;
    }
    ```

1. [Medium - Signal Cat - LeetCode — 351. Android Unlock Patterns](https://medium.com/@rebeccahezhang/leetcode-351-android-unlock-patterns-d9bae4a8a958)