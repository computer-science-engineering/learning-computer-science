# Problem Definition

## Description

Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

**Example 1:**
Given the list `[[1,1],2,[1,1]]`, return **10**. (four 1's at depth 2, one 2 at depth 1)

**Example 2:**
Given the list `[1,[4,[6]]]`, return **27**. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)

## Notes

1. [LeetCode discussion - 2ms easy to understand java solution](https://leetcode.com/problems/nested-list-weight-sum/discuss/79957/2ms-easy-to-understand-java-solution)
1. [LeetCode Article](https://leetcode.com/articles/nested-list-weight-sum/)
1. [LeetCode discussion - Java Solution: similar to tree level order traversal](https://leetcode.com/problems/nested-list-weight-sum/discuss/79933/Java-Solution:-similar-to-tree-level-order-traversal)