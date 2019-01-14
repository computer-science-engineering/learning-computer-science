# Problem Definition

## Description

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are **arranged in a circle**. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and **it will automatically contact the police if two adjacent houses were broken into on the same night**.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight **without alerting the police**.

**Example 1:**

```text
Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
```

**Example 2:**

```text
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
```

## Notes

1. [YT Video - Making Algorithms Simpler - House Robber II | Dynamic Programming | Leetcode | Python](https://www.youtube.com/watch?v=ZQzF60ohOos)
1. [LeetCode discussion - Simple AC solution in Java in O(n) with explanation](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/466/discuss/59934/Simple-AC-solution-in-Java-in-O(n)-with-explanation)