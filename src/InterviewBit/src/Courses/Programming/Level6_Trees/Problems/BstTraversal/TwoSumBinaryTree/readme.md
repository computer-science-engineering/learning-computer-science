# Problem Definition

## Description

Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Notes: Your solution should run in linear time and not take memory more than O(height of T).

Assume all values in BST are distinct.

Example:

```plaintext
Input 1:

T:        10
         / \
        9   20

K = 19

Return: 1

Input 2:

T:        10
         / \
        9   20

K = 40

Return: 0
```

## Notes

1. [LeetCode discussion - Java Simple AC with Time O(n) Space O(log n) in Average](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/106061/Java-Simple-AC-with-Time-O(n)-Space-O(log-n)-in-Average)