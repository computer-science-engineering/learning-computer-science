# Problem Definition

## Description

Given an array of integers `nums` and a positive integer `k`, find whether it's possible to divide this array into `k` non-empty subsets whose sums are all equal.

**Example 1:**

```text
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
```

**Note:**

* `1 <= k <= len(nums) <= 16`.
* `0 < nums[i] < 10000`.

## Notes

1. [LeetCode discussion - [Java/C++]Straightforward dfs solution](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108730/JavaC++Straightforward-dfs-solution)
1. [YT Video - David Yu - Partition to K Equal Sum Subsets](https://www.youtube.com/watch?v=O17fztIRR3I)
1. [LeetCode article](https://leetcode.com/articles/partition-to-k-equal-sum-subsets/)