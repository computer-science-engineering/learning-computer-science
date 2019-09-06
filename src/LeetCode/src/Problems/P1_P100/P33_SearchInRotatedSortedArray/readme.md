# Problem Definition

## Description

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).

You are given a target value to search. If found in the array return its index, otherwise return `-1`.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(*log n*).

**Example 1:**

```plaintext
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

**Example 2:**

```plaintext
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

## Notes

1. [LeetCode discussion - Java AC Solution using once binary search](https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14472/Java-AC-Solution-using-once-binary-search)