# Problem Definition

## Description

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

**Example:**

```plaintext
Input : [1 2 1 2]
Output : 2

Explanation :
  Day 1 : Buy
  Day 2 : Sell
  Day 3 : Buy
  Day 4 : Sell
```

## Notes

1. [LeetCode discussion - A clean DP solution which generalizes to k transactions](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39608/A-clean-DP-solution-which-generalizes-to-k-transactions)
1. [YT Video - Tushar Roy - Buy/Sell Stock With K transactions To Maximize Profit Dynamic Programming](https://www.youtube.com/watch?v=oDhu5uGq_ic)
    Formula is
        maxDiff = max(maxDiff, T[i-1][j-1] - prices[j-1])
        T[i][j] = max(T[i][j-1], prices[j] + maxDiff)
    or   // used for next turn
        T[i][j] = max(T[i][j-1], prices[j] + maxDiff)
        maxDiff = max(maxDiff, T[i-1][j] - prices[j])
1. [GitHub - Tushar Roy](https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/StockBuySellKTransactions.java)
1. [YT Video - Geeks for Geeks - Stock Buy Sell to Maximize Profit](https://www.youtube.com/watch?v=JaosdXkUWTs)