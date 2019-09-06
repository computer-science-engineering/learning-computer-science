# Problem Definition

## Description

LeetCode wants to give one of its best employees the option to travel among **N** cities to collect algorithm problems. But all work and no play makes Jack a dull boy, you could take vacations in some particular cities and weeks. Your job is to schedule the traveling to maximize the number of vacation days you could take, but there are certain rules and restrictions you need to follow.

**Rules and restrictions:**

1. You can only travel among **N** cities, represented by indexes from 0 to N-1. Initially, you are in the city indexed 0 on **Monday**.
2. The cities are connected by flights. The flights are represented as a **N*N** matrix (not necessary symmetrical), called **flights** representing the airline status from the city i to the city j. If there is no flight from the city i to the city j, **flights[i][j] = 0**; Otherwise, **flights[i][j] = 1**. Also, **flights[i][i] = 0** for all i.
3. You totally have **K** weeks (**each week has 7 days**) to travel. You can only take flights at most once **per day** and can only take flights on each week's **Monday** morning. Since flight time is so short, we don't consider the impact of flight time.
4. For each city, you can only have restricted vacation days in different weeks, given an **N*K** matrix called **days** representing this relationship. For the value of **days[i][j]**, it represents the maximum days you could take vacation in the city **i** in the week **j**.

You're given the **flights** matrix and **days** matrix, and you need to output the maximum vacation days you could take during **K** weeks.

**Example 1:**

```plaintext
Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]
Output: 12
Explanation:
Ans = 6 + 3 + 3 = 12.

One of the best strategies is:
1st week : fly from city 0 to city 1 on Monday, and play 6 days and work 1 day.
(Although you start at city 0, we could also fly to and start at other cities since it is Monday.)
2nd week : fly from city 1 to city 2 on Monday, and play 3 days and work 4 days.
3rd week : stay at city 2, and play 3 days and work 4 days.
```

**Example 2:**

```plaintext
Input:flights = [[0,0,0],[0,0,0],[0,0,0]], days = [[1,1,1],[7,7,7],[7,7,7]]
Output: 3
Explanation:
Ans = 1 + 1 + 1 = 3.

Since there is no flights enable you to move to another city, you have to stay at city 0 for the whole 3 weeks.
For each week, you only have one day to play and six days to work.
So the maximum number of vacation days is 3.
```

**Example 3:**

```plaintext
Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[7,0,0],[0,7,0],[0,0,7]]
Output: 21
Explanation:
Ans = 7 + 7 + 7 = 21

One of the best strategies is:
1st week : stay at city 0, and play 7 days.
2nd week : fly from city 0 to city 1 on Monday, and play 7 days.
3rd week : fly from city 1 to city 2 on Monday, and play 7 days.
```

**Note:**

1. **N** and **K** are positive integers, which are in the range of [1, 100].
2. In the matrix **flights**, all the values are integers in the range of [0, 1].
3. In the matrix **days**, all the values are integers in the range [0, 7].
4. You could stay at a city beyond the number of vacation days, but you should **work** on the extra days, which won't be counted as vacation days.
5. If you fly from the city A to the city B and take the vacation on that day, the deduction towards vacation days will count towards the vacation days of city B in that week.
6. We don't consider the impact of flight hours towards the calculation of vacation days.

## Notes

1. [LeetCode solution](https://leetcode.com/problems/maximum-vacation-days/solution/)
1. [mikecoder.github.io/oj-code - Maximum Vacation Days](https://mikecoder.github.io/oj-code/2017/05/01/MaximumVacationDays/)
1. [LeetCode discussion - Java DFS(TLE) and DP Solutions](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/367/discuss/102655/Java-DFS(TLE)-and-DP-Solutions)

    **Solution 1. DFS.** The idea is just try each `possible` city for every week and keep tracking the `max` vacation days. Time complexity O(N^K). Of course it will TLE....

    ```java
    public class Solution {
        int max = 0, N = 0, K = 0;

        public int maxVacationDays(int[][] flights, int[][] days) {
            N = flights.length;
            K = days[0].length;
            dfs(flights, days, 0, 0, 0);

            return max;
        }

        private void dfs(int[][] f, int[][] d, int curr, int week, int sum) {
            if (week == K) {
                max = Math.max(max, sum);
                return;
            }

            for (int dest = 0; dest < N; dest++) {
                if (curr == dest || f[curr][dest] == 1) {
                    dfs(f, d, dest, week + 1, sum + d[dest][week]);
                }
            }
        }
    }
    ```

    **Solution 2. DP.** `dp[i][j]` stands for the max vacation days we can get in week `i` staying in city `j`. It's obvious that `dp[i][j] = max(dp[i - 1][k] + days[j][i]) (k = 0...N - 1, if we can go from city k to city j)`. Also because values of week i only depends on week `i - 1`, so we can compress two dimensional `dp` array to one dimension. Time complexity O(K \* N \* N) as we can easily figure out from the 3 level of loops.

    ```java
    public class Solution {
        public int maxVacationDays(int[][] flights, int[][] days) {
            int N = flights.length;
            int K = days[0].length;
            int[] dp = new int[N];
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[0] = 0;

            for (int i = 0; i < K; i++) {
                int[] temp = new int[N];
                Arrays.fill(temp, Integer.MIN_VALUE);
                for (int j = 0; j < N; j++) {
                    for(int k = 0; k < N; k++) {
                        if (j == k || flights[k][j] == 1) {
                            temp[j] = Math.max(temp[j], dp[k] + days[j][i]);
                        }
                    }
                }
                dp = temp;
            }

            int max = 0;
            for (int v : dp) {
                max = Math.max(max, v);
            }
            return max;
        }
    }
    ```

1. [LeetCode discussion - Java DP Solution](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/367/discuss/112326/Java-DP-Solution)
1. [LeetCode discussion - Naive DFS -> DFS w/ memo -> 2D-DP -> 1D-DP](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/367/discuss/159704/Naive-DFS-greater-DFS-w-memo-greater-2D-DP-greater-1D-DP)