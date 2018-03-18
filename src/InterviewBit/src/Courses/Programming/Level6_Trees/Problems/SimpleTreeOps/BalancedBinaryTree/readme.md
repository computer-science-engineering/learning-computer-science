# Problem Definition

## Description

Given a binary tree, determine if it is height-balanced.

Height-balanced binary tree: is defined as a binary tree in which the depth of the two sub-trees of every node never differ by more than 1.
Return `0 / 1` (0 for false, 1 for true) for this problem.

**Example:**

```text
Input 1:
          1
         / \
        2   3

Return: True or 1

Input 2:
         3
        /
       2
      /
     1

Return: False or 0
        Because for the root node, left subtree has depth 2 and right subtree has depth 0.
        Difference = 2 > 1.
```

## Notes

1. [LeetCode discussion - Two approaches](https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better)