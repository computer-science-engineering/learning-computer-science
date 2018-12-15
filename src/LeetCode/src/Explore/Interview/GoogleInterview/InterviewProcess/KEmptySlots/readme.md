# Problem Definition

## Description

There is a garden with `N` slots. In each slot, there is a flower. The `N` flowers will bloom one by one in `N` days. In each day, there will be `exactly` one flower blooming and it will be in the status of blooming since then.

Given an array `flowers` consists of number from `1` to `N`. Each number in the array represents the place where the flower will open in that day.

For example, `flowers[i] = x` means that the unique flower that blooms at day `i` will be at position `x`, where `i` and `x` will be in the range from `1` to `N`.

Also given an integer `k`, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is `k` and these flowers are not blooming.

If there isn't such day, output -1.

**Example 1:**

```text
Input:
flowers: [1,3,2]
k: 1
Output: 2
Explanation: In the second day, the first and the third flower have become blooming.
```

**Example 2:**

```text
Input:
flowers: [1,2,3]
k: 1
Output: -1
```

**Note:**

1. The given array will be in the range [1, 20000].

## Notes

1. [YT Video - Yusen Zhang - 30 Min Java Coding Challenge - K Empty Slots](https://www.youtube.com/watch?v=BKOgB5pa57c)
1. [LeetCode solution](https://leetcode.com/problems/k-empty-slots/solution/)
1. [LeetCode discussion - [Java/C++] Simple O(n) solution](https://leetcode.com/explore/interview/card/google/67/sql-2/470/discuss/107931/JavaC++-Simple-O(n)-solution)