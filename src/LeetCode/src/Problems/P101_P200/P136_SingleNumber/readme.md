# Problem Definition

## Description

Given a **non-empty** array of integers, every element appears twice except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

**Example 1:**

```text
Input: [2,2,1]
Output: 1
```

**Example 2:**

```text
Input: [4,1,2,1,2]
Output: 4
```

## Notes

1. [LeetCode solution](https://leetcode.com/problems/single-number/solution/)
1. [LeetCode discussion - Beats 100% of java submissions](https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/discuss/143855/Beats-100-of-java-submissions)

    use XOR operator as XORing the same number gives 0.