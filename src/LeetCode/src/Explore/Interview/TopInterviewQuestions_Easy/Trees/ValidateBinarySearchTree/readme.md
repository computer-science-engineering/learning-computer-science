# Problem Definition

## Description

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

* The left subtree of a node contains only nodes with keys **less than** the node's key.
* The right subtree of a node contains only nodes with keys **greater than** the node's key.
* Both the left and right sub-trees must also be binary search trees.

**Example 1:**

```plaintext
Input:
    2
   / \
  1   3
Output: true
```

**Example 2:**

```plaintext
    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
```

## Notes

1. [LeetCode discussion - My simple Java solution in 3 lines](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/discuss/32109/My-simple-Java-solution-in-3-lines)
1. [LeetCode discussion - Learn one iterative inorder traversal, apply it to multiple tree questions (Java Solution)](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution))