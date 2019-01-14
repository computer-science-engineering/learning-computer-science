# Problem Definition

## Description

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and **it will automatically contact the police if two adjacent houses were broken into on the same night**.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight **without alerting the police**.

**Example 1:**

```text
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
```

**Example 2:**

```text
Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
```

## Notes

1. [YT Video - Aditya Srivastava - House Robber | leetcode 198 explanation | Dynamic Programming](https://www.youtube.com/watch?v=YXPsaVdyopM)
1. [Recursion to 1 dimensional dynamic programing III](http://www.gorecursion.com/algorithm/2016/11/20/1d-dynamic3.html)
1. [LeetCode discussion - JAVA DP Solution, O(n) runtime and O(1) space, with inline comment](https://leetcode.com/problems/house-robber/discuss/55695/JAVA-DP-Solution-O(n)-runtime-and-O(1)-space-with-inline-comment)

    ```java
    public int rob(int[] num) {
        int rob = 0; //max money can get if rob current house
        int not_rob = 0; //max money can get if not rob current house
        for(int i=0; i<num.length; i++) {
            int cur_rob = not_rob + num[i]; //if rob current value, previous house must not be robbed
            not_rob = Math.max(not_rob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = cur_rob;
        }
        return Math.max(rob, not_rob);
    }
    ```

1. [LeetCode discussion - Java O(n) solution, space O(1)](https://leetcode.com/problems/house-robber/discuss/55681/Java-O(n)-solution-space-O(1))

    ```java
    public int rob(int[] num) {
        int[][] dp = new int[num.length + 1][2];
        for (int i = 1; i <= num.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = num[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[num.length][0], dp[num.length][1]);
    }
    ```

    dp[i][1] means we rob the current house and dp[i][0] means we don't,

    so it is easy to convert this to O(1) space

    ```java
    public int rob(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }
    ```

1. [LeetCode solution](https://leetcode.com/problems/house-robber/solution/)