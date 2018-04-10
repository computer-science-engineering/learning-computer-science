# Problem Definition

## Description

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

**Example:**

Given the below binary tree,

```text
       1
      / \
     2   3
```

Return `6`.

## Notes

1. [Geeks for Geeks - Maximum Path Sum in a Binary Tree](https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/)

    For each node there can be four ways that the max path goes through the node:

    1. Node only
    1. Max path through Left Child + Node
    1. Max path through Right Child + Node
    1. Max path through Left Child + Node + Max path through Right Child

    The idea is to keep trace of four paths and pick up the max one in the end. An important thing to note is, root of every subtree need to return maximum path sum such that at most one child of root is involved. This is needed for parent function call. In below code, this sum is stored in ‘max_single’ and returned by the recursive function.

1. [YT Video - Geeks for Geeks - Maximum Path Sum in a Binary Tree](https://www.youtube.com/watch?v=cSnETAcziS0)